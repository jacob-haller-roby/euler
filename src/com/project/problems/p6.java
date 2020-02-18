package com.project.problems;

import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p6 extends ProblemBase {

    private static Integer start = 101;

    public Long execute() {
        System.out.println(sumSquares(start));
        System.out.println(squareSum(start));
        return Long.valueOf(sumSquares(start) - squareSum(start));
    }

    public static Integer squareSum(Integer number) {
        return IntStream.range(1, number).reduce(0, (acc, cur) -> acc + (int) Math.pow(cur, 2));
    }

    public static Integer sumSquares(Integer number) {
        return (int) Math.pow(IntStream.range(1, number).sum(), 2);
    }
}
