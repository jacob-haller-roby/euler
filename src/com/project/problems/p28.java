package com.project.problems;

import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p28 extends ProblemBase {

    private static Long size = 1001l;
    public Long execute() {
        Long result = 1l;

        Long node = 1l;
        for(int edge = 3; edge <= size; edge+=2) {
            for(int side = 0; side < 4; side++) {
                node += edge - 1;
                result += node;
            }
        }

        return result;
    }
}
