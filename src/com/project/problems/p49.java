package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.CharArray;
import com.project.util.Combinations;
import com.project.util.Permutations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class p49 extends ProblemBase {

    public Long execute() {

        return LongStream.range(1000, 10000)
            .mapToObj(i -> Permutations.transform(i).stream().filter(primes::isPrime).sorted().collect(Collectors.toList()))
            .map(permutations -> new ArrayList<Long>(permutations.stream().distinct().collect(Collectors.toList())))
            .map(permutations -> Combinations.getCombinations(permutations, 3))
            .flatMap(Collection::stream)
            .distinct()
            .map(permutations -> new ArrayList<Long>(permutations))
            .filter(permutations -> permutations.get(0) != 1487 && permutations.get(1) - permutations.get(0) == permutations.get(2) - permutations.get(1))
            .map(permutations -> permutations.stream().map(Objects::toString).reduce("", (acc, cur) -> acc + cur))
            .mapToLong(Long::valueOf)
            .findAny()
            .orElse(0l);

    }
}
