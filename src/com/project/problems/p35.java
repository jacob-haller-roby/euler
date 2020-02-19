package com.project.problems;

import com.project.util.ProblemBase;
import com.project.util.Rotations;

public class p35 extends ProblemBase {

    public static int limit = 1000000;

    public Long execute() {

        primes.fillBelow(limit);

        return primes.stream().filter(prime ->
                Rotations.transform(prime).stream().allMatch(rotation -> primes.isPrime(rotation))
        ).count();

    }
}
