package com.project.problems;

import com.project.base.ProblemBase;

public class p58 extends ProblemBase {

    public Long execute() {
        long value = 1;
        double primeCount = 0;
        int numberCount = 1;
        for(long sideSize = 2; ; sideSize += 2) {

            for(int side = 0; side < 4; side++){
                value += sideSize;
                if(primes.isPrime(value)){
                    primeCount++;
                }
                numberCount++;
            }

            if(primeCount / numberCount < 0.1) {
                return sideSize +1;
            }
        }
    }
}
