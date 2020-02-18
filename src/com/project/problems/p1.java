package com.project.problems;

import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p1 extends ProblemBase {

    public Long execute() {
        return IntStream.range(1,1000).filter(i -> i % 3 == 0 || i % 5 == 0).mapToLong(Long::valueOf).sum();
    }
}
