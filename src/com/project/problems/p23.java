package com.project.problems;

import com.project.util.Factors;
import com.project.base.ProblemBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.LongStream;

public class p23 extends ProblemBase {

    private static ArrayList<Long> abundantNumbers = new ArrayList<>();
    private static HashMap<Long, Boolean> abundantSums = new HashMap<>();

    @Override
    public Long execute() {

        timer.start();
        while(28123 - 12 > largestAbundantNumber()){
            getNextAbundantNumber();
        }
        timer.stop("got abundant numbers in");

        timer.start();
        abundantNumbers.stream().forEach(a -> abundantNumbers.stream().filter(b -> b >=a).forEach(b -> abundantSums.put(a+b, true)));
        timer.stop("got abundant sums in");

        timer.start();
        long count = LongStream.range(1,28124).filter(a -> !abundantSums.containsKey(a)).sum();
        timer.stop("found total sum in");

        return count;
    }

    public static void getNextAbundantNumber() {
        if(abundantNumbers.isEmpty()) {
            abundantNumbers.add(12l);
            return;
        }

        Factors factors = new Factors();
        Long test = abundantNumbers.get(abundantNumbers.size() - 1);
        while(factors.properSum() <= test) {
            test++;
            factors.set(test);
        }
        abundantNumbers.add(test);
    }

    public static Long largestAbundantNumber() {
        if(abundantNumbers.isEmpty()) abundantNumbers.add(12l);
        return abundantNumbers.get(abundantNumbers.size() - 1);
    }
}
