package com.project.problems;

import com.project.util.Pandigital;
import com.project.util.Permutations;
import com.project.util.ProblemBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class p41 extends ProblemBase {

    public Long execute() {

        ArrayList<String> pandigitals = new ArrayList<>();
        pandigitals.add("1");
        for(int i = 2; i < 10; i++) {
            pandigitals.add(pandigitals.get(pandigitals.size()-1) + i);
        }

        return pandigitals.stream()
                .mapToLong(Long::valueOf)
                .mapToObj(p -> Permutations.transform(p))
                .flatMap(ArrayList::stream)
                .filter(p -> primes.isPrime(p))
                .max(Long::compareTo)
                .get();

    }
}
