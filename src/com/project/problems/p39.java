package com.project.problems;

import com.project.base.ProblemBase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

public class p39 extends ProblemBase {

    // a + b + c <= 1000
    // c < a + b
    // 2c < 1000

    // a^2 + b^2 = c^2

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public Long execute() {

        IntStream.range(3, 501).forEach(c -> {
            IntStream.range(1, c-1).forEach(a -> {
                double b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
                boolean perfect = b == Math.floor(b);

                if(perfect) {
                    int p = (int) (a + b + c);
                    if (map.containsKey(p)) {
                        map.put(p, map.get(p) + 1);
                    } else {
                        map.put(p, 1);
                    }
                }
            });
        });

        return (long) map.keySet().stream().max(Comparator.comparingInt(a -> map.get(a))).orElse(0);
    }
}
