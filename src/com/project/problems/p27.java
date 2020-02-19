package com.project.problems;

import com.project.base.ProblemBase;
import java.util.HashMap;
import java.util.stream.LongStream;

public class p27 extends ProblemBase {

    public Long execute() {
        long result;

        HashMap<Long , Long > map = new HashMap<>(); // k = consecutive primes, v = product

        while(primes.largestPrime() < 1000) primes.getNextPrime();
        primes.pop();

        LongStream.range(-999,1000).forEach(a -> {
            primes.forEach(b -> {
                Long  primes = consecutivePrimes(a,b);
                map.put(primes, (a*b));

                primes = consecutivePrimes(a, -b);
                map.put(primes, -a*b);
            });
        });

        Long  maxConsecutivePrimes = map.keySet().stream().max(Long ::compareTo).orElse(0l);
        result = (long) map.get(maxConsecutivePrimes);

        return result;
    }

    public Long consecutivePrimes(Long a, Long b) {

        Long count = 0l;
        while(primes.isPrime((long) formula(count, a, b))) {
            if(a == -971 && b == 61 && count == 1){
                Long prime = formula(count, a, b);
                System.out.println(count + ": " + prime + " is prime");
            }
            count++;
        }
        return count;

    }

    public Long formula(Long n, Long a, Long b) {
        return (int) Math.pow(n,2) + (a * n) + b;
    }
}
