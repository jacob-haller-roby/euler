package com.project.problems;

import com.project.base.ProblemBase;

public class p46 extends ProblemBase {

    public Long execute() {
        for(long i = 9; ; i+=2) {
            if(primes.isPrime(i)) continue;
            primes.fillAbove((int) i);

            long finalI = i;
            boolean match = primes.stream().anyMatch(p ->
                Math.sqrt((finalI - p)/2) % 1 == 0
             );

            if(!match) {
                return i;
            }
        }
    }
}
