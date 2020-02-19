package com.project.problems;

import com.project.util.Factors;
import com.project.base.ProblemBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class p21 extends ProblemBase {

    public static ArrayList<Integer> amicableNumbers = new ArrayList<>();
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public Long execute() {
        IntStream.range(2,10000).forEach(i -> {
            Factors factors = new Factors(i);
            Integer value = (int) factors.stream().mapToLong(Long::longValue).sum() + 1;
            map.put(i, value);
        });

        IntStream.range(2,10000).forEach(i -> {
            int pair = map.get(i);

            if(map.containsKey(pair) && pair != i && map.get(pair) == i ) {
                amicableNumbers.add(i);
            }
        });

        Integer sum = amicableNumbers.stream().mapToInt(Integer::intValue).sum();
        return Long.valueOf(sum);
    }
}
