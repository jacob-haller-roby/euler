package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;

public class p3 extends ProblemBase {

    static Long number = 600851475143l;

    public Long execute() {

        Long largestFactor = number;
        ArrayList<Long> factors = new ArrayList<>();

        for(long i = 3l; i <= largestFactor; i += 2){
            if(i == -1) break;
            while(largestFactor % i == 0) {
                largestFactor = largestFactor / i;
                factors.add(i);
            }
        }

        return factors.get(factors.size() - 1);

    }
}
