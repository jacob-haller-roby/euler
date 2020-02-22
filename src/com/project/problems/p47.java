package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.PrimeFactors;

import java.util.*;
import java.util.stream.LongStream;

public class p47 extends ProblemBase {

    public Long execute() {

        Map<Long, Integer> map = new HashMap<>();

        for(long i = 1; ; i++) {
            boolean match = LongStream.range(i, i+4).allMatch(j -> {
                if(!map.containsKey(j)) {
                    PrimeFactors primeFactors = new PrimeFactors(primes, j);
                    Set<Long> distinctPrimeFactors = new HashSet<>(primeFactors);
                    map.put(j, distinctPrimeFactors.size());
                }
                return map.get(j) == 4;
            });

            if(match) {
                return i;
            }
        }
    }
}
