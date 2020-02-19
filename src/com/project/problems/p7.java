package com.project.problems;

import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p7 extends ProblemBase {

    public Long execute() {
        IntStream.range(0,10001).forEach(i -> primes.getNextPrime());
        System.out.println(primes.largestPrime());
        return (long) primes.size();
    }

}
