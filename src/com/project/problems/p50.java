package com.project.problems;

import com.project.base.ProblemBase;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class p50 extends ProblemBase {

    static int upperBound = 1000000;
    public Long execute() {

        primes.fillAbove(upperBound);

        AtomicInteger maxChain = new AtomicInteger();
        AtomicLong bestPrime = new AtomicLong();

        IntStream.range(0, primes.size())
                .parallel()
                .forEach(i -> {
                    long prime = primes.get(i);
                    long sum = prime;

                    for(int index = i+1; sum < upperBound; index++) {

                        if(primes.isPrime(sum)){

                            int currentChain = index - i;
                            if(currentChain > maxChain.get()) {
                                maxChain.set(currentChain);
                                bestPrime.set(sum);
                            }
                        }
                        prime = primes.get(index);
                        sum += prime;
                    }
                });

        return bestPrime.get();

    }
}
