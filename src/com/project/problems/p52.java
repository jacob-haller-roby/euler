package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Permutations;

import java.util.List;
import java.util.stream.LongStream;

public class p52 extends ProblemBase {

    public Long execute() {
        for(long i = 100; ; i++) {
            List<Long> permutations = Permutations.transform(i);
            long finalI = i;
            boolean match = LongStream.range(2,7)
                    .map(n -> n* finalI)
                    .allMatch(permutations::contains);
            if(match) {
                return i;
            }
        }
    }
}
