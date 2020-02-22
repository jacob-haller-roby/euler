package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Permutations;
import com.project.util.Primes;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p43 extends ProblemBase {

    public Long execute() {
        timer.start();
        ArrayList<String> pandigitals = Permutations.transform("0123456789");
        System.out.println(pandigitals.size());
        timer.stop("pandigital creation");

        timer.start();
        Primes primes = new Primes();
        primes.fillAbove(17);
        timer.stop("prime creation");

        timer.start();
        long result = pandigitals.stream()
                .filter(pandigital ->
                        IntStream.range(0,7).allMatch(i ->
                            Integer.parseInt(
                                IntStream.range(i+1,i+4)
                                        .map(pandigital::charAt)
                                        .mapToObj(Character::toString)
                                        .collect(Collectors.joining(""))
                            ) % primes.get(i) == 0
                        )
                )
                .mapToLong(Long::valueOf)
                .sum();
        timer.stop("stream");
        return result;
    }
}
