package com.project.problems;

import com.project.base.ProblemBase;

import java.util.stream.LongStream;

public class p48 extends ProblemBase {

    public Long execute() {

        return LongStream.range(1,1001).map(i -> {
            long ia = i;
            for(int j = 1; j < i; j++) {
                ia *= i;
                ia %= 10000000000L;
            }
            return ia;
        }).sum();
    }
}
