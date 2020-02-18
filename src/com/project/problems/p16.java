package com.project.problems;

import com.project.util.ProblemBase;

import java.util.ArrayList;

public class p16 extends ProblemBase {

    private static ArrayList<Integer> product = new ArrayList<>();
    private static Integer power = 1000;

    public Long execute() {

        product.add(2);
        Integer carryOver = 0;

        for(Integer i = 0; i < power - 1; i++) {
            for(Integer j = 0; j < product.size(); j++) {
                Integer value = product.get(j) * 2 + carryOver;
                carryOver = value / 10;
                product.set(j, value % 10);
            }

            while(carryOver > 0) {
                product.add(carryOver%10);
                carryOver /= 10;
            }
        }

        System.out.println(product);

        Integer result = product.stream().mapToInt(Integer::intValue).sum();

        return Long.valueOf(result);
    }
}
