package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.ArrayNumber;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p53 extends ProblemBase {

    static int maxN = 100;

    public Long execute() {
        return LongStream.range(1,maxN +1)
                .map(n -> LongStream.range(1,n+1)
                        .mapToObj(r-> combinationCount(n,r))
                        .filter(total -> total.compareTo(BigInteger.valueOf(1000000)) > 0)
                        .count()
                )
                .sum();
    }

    public BigInteger combinationCount(Long n, Long r) {
        BigInteger numerator = LongStream.range(r+1, n+1).mapToObj(BigInteger::valueOf).reduce(BigInteger.valueOf(1), BigInteger::multiply);
        BigInteger denominator = LongStream.range(1, n-r+1).mapToObj(BigInteger::valueOf).reduce(BigInteger.valueOf(1), BigInteger::multiply);
        return numerator.divide(denominator);
    }
}
