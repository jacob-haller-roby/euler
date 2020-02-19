package com.project.problems;

import com.project.util.ProblemBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class p32 extends ProblemBase {

    public Long execute() {
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i < 99; i++) {
            for(int j = i+1; j<9999; j++) {
                Integer product = i * j;
                String string = product.toString() + i + j;
                if(string.length() > 10) {
                    break;
                }
                if(string.matches("(?:([1-9])(?!.*\\1)){9}")) {
                    set.add(product);
                }
            }
        }

        return set.stream().mapToLong(Integer::intValue).sum();
    }
}
