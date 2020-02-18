package com.project.problems;

import com.project.util.ArrayNumber;
import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p20 extends ProblemBase {

    private static ArrayNumber factorial =  new ArrayNumber();
    private static Integer n = 100;

    public Long execute() {
        factorial.setToInt(1);

        IntStream.range(1,n+1).forEach( i -> factorial.multiply(i));

        Integer sum = factorial.digitSum();

        return Long.valueOf(sum);

    }
}
