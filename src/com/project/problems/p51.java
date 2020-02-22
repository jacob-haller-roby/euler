package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.CharArray;
import com.project.util.Permutations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p51 extends ProblemBase {

    private static int digitStart = 6;
    private static int familySize = 8;

    public Long execute() {

        long result = 0L;

        for(int digits = digitStart; result == 0; digits++) {

            List<List<Boolean>> swapArrays = generateSwapArray(digits);
            long lowerBound = (long) Math.pow(10, digits - 1);
            long upperBound = (long) Math.pow(10, digits);

            int startingPrimeIndex = 0;
            while(primes.get(startingPrimeIndex) < lowerBound) startingPrimeIndex++;

            for(int i = startingPrimeIndex; primes.get(i) < upperBound; i++) {

                int finalI = i;
                result = swapArrays.stream()
                        .map(swapArray -> IntStream.range(0,10)
                                    .mapToLong(digit -> doSwap(primes.get(finalI), digit, swapArray))
                                    .filter(swappedValue -> primes.isPrime(swappedValue))
                                    .filter(swappedValue -> swappedValue > lowerBound)
                                    .sorted()
                                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                        )
                        .filter(swappedPrimes -> swappedPrimes.size() == familySize)
                        .mapToLong(swappedPrimaries -> (long) swappedPrimaries.get(0))
                        .findAny()
                        .orElse(result);
                if(result != 0) break;
            }
        }

        return result;
    }

    public Long doSwap(Long number, int digit, List<Boolean> swapArray) {
        String numberString = number.toString();
        return IntStream.range(0, swapArray.size())
            .mapToLong(i -> swapArray.get(i) ? digit : Integer.parseInt(numberString.substring(i,i+1)))
            .reduce(0, (acc, cur) -> acc *10 + cur);
    }

    public List<List<Boolean>> generateSwapArray(int length) {

        Set<String> swapArrays = new HashSet<>();

        for(int i = 1; i < length; i++) {
            String swapString =
                    "*".repeat(i) +
                    " ".repeat(length - i);
            swapArrays.addAll(Permutations.transform(swapString));
        }

        return swapArrays.stream()
                .map(s -> new CharArray(s).stream()
                        .map(character -> String.valueOf(character).equals("*"))
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());

    }
}
