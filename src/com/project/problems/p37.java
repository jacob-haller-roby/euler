package com.project.problems;

import com.project.util.ProblemBase;

import java.util.ArrayList;

public class p37 extends ProblemBase {

    public Long execute() {

        Long sum = 0L;
        Long foundCount = 0L;
        primes.fillBelow(10);
        while(foundCount < 11) {
            Long prime = primes.getNextPrime();
            ArrayList<Long> truncations = getTruncations(prime);
            if(truncations.stream().allMatch(t -> primes.isPrime(t))) {
                foundCount++;
                sum += prime;
            }
        }

        return sum;
    }

    private ArrayList<Long> getTruncations(Long number) {
        ArrayList<Long> truncations = new ArrayList<>();
        truncations.add(number);
        truncations.addAll(getTruncateLeft(number));
        truncations.addAll(getTruncateRight(number));
        return truncations;
    }

    private ArrayList<Long> getTruncateLeft(Long number) {
        String string = number.toString();
        ArrayList<Long> truncations = new ArrayList<>();
        while(string.length() > 1) {
            string = string.substring(1);
            truncations.add(Long.valueOf(string));
        }
        return truncations;
    }

    private ArrayList<Long> getTruncateRight(Long number) {
        ArrayList<Long> truncations = new ArrayList<>();
        while(number > 0) {
            truncations.add(number);
            number /= 10;
        }
        return truncations;
    }
}
