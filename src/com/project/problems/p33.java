package com.project.problems;

import com.project.util.Primes;
import com.project.util.ProblemBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class p33 extends ProblemBase {

    static Primes primes = new Primes();

    public Long execute() {

        ArrayList<Integer> numerators = new ArrayList<>();
        ArrayList<Integer> denominators = new ArrayList<>();

        for(int i = 11; i < 100; i++) {
            int i1 = i /10;
            int i2 = i %10;

            for(int j = i+1; j < 100; j++) {
                int j1 = j/10;
                int j2 = j%10;

                if (j2 == 0 && i2 == 0) {
                    continue;
                }

                if (
                        (i1 == j1 && (double) i2/j2 == (double) i/j)
                    || (i1 == j2 && (double) i2/j1 == (double) i/j)
                    || (i2 == j1 && (double) i1/j2 == (double) i/j)
                    || (i2 == j2 && (double) i1/j1 == (double) i/j)
                ){
                    numerators.add(i);
                    denominators.add(j);
                }

            }
        }

        ArrayList<Long> numeratorPrimes = (ArrayList<Long>) numerators.stream().map(i -> primes.getPrimeFactors((long) i)).flatMap(Collection::stream).collect(Collectors.toList());
        ArrayList<Long> denominatorPrimes = (ArrayList<Long>) denominators.stream().map(i -> primes.getPrimeFactors((long) i)).flatMap(Collection::stream).collect(Collectors.toList());

        return denominatorPrimes.stream().filter(i -> {
            if(numeratorPrimes.contains(i)) {
                numeratorPrimes.remove(i);
                return false;
            }
            return true;
        }).reduce(1l, (acc, cur) ->  cur * acc);
    }
}
