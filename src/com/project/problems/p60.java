package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Combinations;
import com.project.util.Timer;

import java.util.ArrayList;
import java.util.HashMap;

public class p60 extends ProblemBase {

    private static int familySize = 5;
    private static Timer timer2 = new Timer();

    public Long execute() {

        long result = 0;
        HashMap<Long, ArrayList<Long>> map = new HashMap<>();

        for(int i = 0; result == 0; i++) {
            timer.resume();
            update(i, map);
            timer.pause();

            timer2.resume();
            result = findSum(primes.get(i), map);
            timer2.pause();
        }

        timer.print("Update timing: ");
        timer2.print("Search timing: ");

        return result;
    }

    public void update(int maxIndex, HashMap<Long, ArrayList<Long>> map) {

        Long newPrime = primes.get(maxIndex);
        ArrayList<Long> matchingPrimes = new ArrayList<>();

        for(int i = 0; i < maxIndex; i++ ) {
            Long oldPrime = primes.get(i);
            String a = newPrime.toString();
            String b = oldPrime.toString();
            Long ab = Long.valueOf(a + b);
            Long ba = Long.valueOf(b + a);
            if(primes.isPrime(ab) && primes.isPrime(ba)) {
                matchingPrimes.add(oldPrime);
                map.get(oldPrime).add(newPrime);
            }
        }

        map.put(newPrime, matchingPrimes);
    }

    public Long findSum(long maxPrime, HashMap<Long, ArrayList<Long>> map) {

        // find n lists
        // each list shares n-1 elements with the others
        ArrayList<ArrayList<Long>> combinations = Combinations.getCombinations(map.get(maxPrime), familySize - 1);
        return combinations.stream()
                .parallel()
                .filter(combination -> combination.stream()
                    .allMatch(c -> combination.stream()
                        .allMatch(d -> d.equals(c) || map.get(c).contains(d))
                    )
                )
                .peek(list -> list.add(maxPrime))
                .filter(k -> k.size() > 1)
                .findAny()
                .orElse(new ArrayList<>())
                .stream()
                .peek(System.out::println)
                .mapToLong(Long::longValue)
                .sum();
    }


}
