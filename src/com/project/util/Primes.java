package com.project.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Primes extends ArrayList<Long> {

    public Primes() {
        super();
    }

    public Long getNextPrime() {
        Long value;
        if(isEmpty()) {
            value = 2l;
        } else {
            value = this.get(this.size() - 1);
            if(value % 2 == 0) {
                value += 1;
            } else {
                value += 2;
            }
            while (!isPrime(value)) value+=2;
        }

        add(value);
        return value;
    }

    public Boolean isPrime(Long test) {
        if (test == 1) return false;
        while(Math.pow(this.largestPrime(),2) <= Math.abs(test) ) getNextPrime();

        Long value = this.stream()
                .filter(i -> test % i == 0 || Math.pow(i,2) > Math.abs(test))
                .findFirst()
                .orElse(null);
        return test % value != 0;
    }

    public ArrayList<Long> getPrimeFactors(Long number) {
        ArrayList<Long> result = new ArrayList<>();

        if(isPrime(number)) return result;

        Long test = number;
        Integer i = 0;
        while (test != 1) {
            if(i > size() - 1){
                getNextPrime();
            }

            if(test % get(i) == 0) {
                result.add(get(i));
                test /= get(i);
            } else {
                i++;
            }
        }

        return result;
    }

    public Long largestPrime() {
        if(isEmpty()) {
            add(2l);
        }
        return get(size() - 1);
    }

    public Long pop() {
        Long value = largestPrime();
        remove(size() - 1);
        return value;
    }
}
