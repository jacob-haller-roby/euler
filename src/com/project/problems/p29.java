package com.project.problems;

import com.project.util.Primes;
import com.project.util.ProblemBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p29 extends ProblemBase {

    private static int upperBound = 100;

    public Long execute() {

        HashMap<Integer, Integer> counts = new HashMap<>();


        IntStream.range(2,upperBound+1).forEach(a -> {
            ArrayList<Integer> roots = new ArrayList<>();
            ArrayList<Integer> powers = new ArrayList<>();
            for(int root = 2; root <= (int) Math.floor(Math.sqrt(a)); root++){
                double power = Math.log(a) / Math.log(root);
                if(Math.floor(power) == power) {
                    roots.add(root);
                    powers.add((int) power);
                }
            }
            int toAdd = (int) IntStream.range(2,upperBound + 1).filter(b ->
                IntStream.range(0,roots.size()).noneMatch(index -> {
                    int root = roots.get(index);
                    int power = powers.get(index);
                    boolean duplicate = IntStream.range(1,power).anyMatch(p ->
                            b*power%p == 0 && b*power/p <= upperBound
                    );
                    return duplicate;
                })
            ).count();

            counts.put(a, toAdd);

        });

        return counts.values().stream().mapToLong(Integer::intValue).sum();
    }
}

/*
x^4 =(x^2)^2

a^b = (a^c)^b
for b divisible by 2->6 (set as c)
if a^c <=100, don't count

32^3 = 8^5 = 2^15
 */