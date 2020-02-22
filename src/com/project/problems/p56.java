package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.CharArray;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p56 extends ProblemBase {

    public Long execute() {

        return LongStream.range(1,101)
                .map(a -> IntStream.range(1,101).mapToLong(b-> getSum(BigInteger.valueOf(a).pow(b))).max().orElse(0))
                .max()
                .orElse(0);
    }

    public Long getSum(BigInteger n) {
        CharArray characters = new CharArray(n.toString());
        return characters.toInts().stream().mapToLong(Long::valueOf).sum();
    }
}
