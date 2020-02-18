package com.project.problems;

import com.project.util.ProblemBase;

import java.util.HashMap;

public class p5 extends ProblemBase {

    public Long execute() {
        HashMap<Integer, Integer> factors = new HashMap<>();
        for (Integer i = 1; i <= 20; i++) {
            HashMap<Integer, Integer> newFactors = getFactors(i);
            newFactors.keySet().stream().forEach(factor -> {
                Integer count = newFactors.get(factor);
                factors.putIfAbsent(factor, count);
                if(factors.get(factor) < count) {
                    factors.put(factor, count);
                }
            });
        }

        Integer result = factors.keySet().stream().reduce(1, (acc, factor) -> acc *  (int) Math.pow(factor,  factors.get(factor)));

        return Long.valueOf(result);
    }

    public static HashMap<Integer, Integer> getFactors(Integer number) {
        Integer highestFactor = number;
        HashMap<Integer, Integer> factors = new HashMap<>();

        for (Integer i = 2; i <= highestFactor; i++) {
            while (highestFactor % i == 0) {
                highestFactor /= i;
                factors.putIfAbsent(i, 0);
                factors.put(i, factors.get(i) + 1);
            }
        }

        return factors;

    }
}
