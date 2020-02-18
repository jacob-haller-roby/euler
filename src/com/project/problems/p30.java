package com.project.problems;

import com.project.util.ProblemBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class p30 extends ProblemBase {

    HashMap<Integer, Integer> map = new HashMap<>();

    public Long execute() {
        IntStream.range(0,10).forEach(i -> map.put(i, (int) Math.pow(i,5)));

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 2; i < 1000000; i++) {
            if(isMatch(i)) numbers.add(i);
        }

        System.out.println(numbers);
        return numbers.stream().mapToLong(Integer::intValue).sum();
    }

    public boolean isMatch(int num) {
        int test = num;
        int sum = 0;
        while(test > 0) {
            sum += map.get(test%10);
            test /= 10;
        }

        return sum == num;
    }
}
