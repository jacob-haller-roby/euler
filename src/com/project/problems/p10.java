package com.project.problems;

import com.project.base.ProblemBase;

public class p10 extends ProblemBase {

    public static Long limit = 2000000l;

    public Long execute() {
        Long highestPrime = primes.getNextPrime();

        while(highestPrime < limit){
            highestPrime = primes.getNextPrime();
        }

        primes.pop();
        Long sum = primes.stream().mapToLong(i -> (long) i).sum();
        return sum;
    }
}
