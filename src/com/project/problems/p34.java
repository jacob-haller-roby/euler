package com.project.problems;

import com.project.base.ProblemBase;

import java.util.HashMap;

public class p34 extends ProblemBase {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public Long execute() {
        init();
        long result = 0L;
        for(int i = 10; i <= 2540160; i++) {
            int sum = 0;
            int start = i;
            while(start > 0) {
                sum += map.get(start%10);
                start /= 10;
            }

            if(sum == i) {
                result += i;
            }

        }
        return result;
    }

    public void init() {
        int factorial = 1;
        map.put(0,factorial);
        for(int i = 1; i < 10; i++) {
            factorial *= i;
            map.put(i, factorial);
        }
    }
}
