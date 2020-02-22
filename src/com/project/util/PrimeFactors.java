package com.project.util;

import java.util.ArrayList;

public class PrimeFactors extends Factors {
    public PrimeFactors() {
        primes = new Primes();
    }
    public PrimeFactors(Primes primes) {
        super();
        this.primes = primes;
    };
    public PrimeFactors(Primes primes, Long num) {
        this.primes = primes;
        init(num);
    }
    public PrimeFactors(Primes primes, Integer num) {
        this.primes = primes;
        init((long) num);
    }

    private static Primes primes;

    @Override
    protected void init(Long num) {
        primes.fillAbove(num);

        primes.forEach(prime -> {
            long p = prime;
            while (num % p == 0) {
                add(prime);
                p *= prime;
            }
        });
        sort(Long::compare);
    }


}
