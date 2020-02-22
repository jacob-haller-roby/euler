package com.project.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Primes extends ArrayList<Long> {

    public Primes() {
        super();
    }

    public void fillBelow(int i) {
        fillBelow((long) i);
    }
    public void fillAbove(int i) {fillAbove((long) i);
    }

    public void fillBelow(long i) {
        while(largestPrime() < i) getNextPrime();
        pop();
    }
    public void fillAbove(long i) {
        while(largestPrime() < i) getNextPrime();
    }

    public Long get(int i) {
        while(size() <= i) getNextPrime();
        return super.get(i);
    }

    public Long getNextPrime() {
        Long value;
        if(isEmpty()) {
            value = 2L;
        } else {
            value = largestPrime();
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

        if(test == 2L) return true;

        Long value = this.stream()
                .filter(i -> (test % i == 0 && !test.equals(i)) || Math.pow(i,2) > Math.abs(test))
                .findFirst()
                .orElse(null);
        return test % value != 0;
    }

    public ArrayList<Long> getPrimeFactors(Long number) {
        ArrayList<Long> result = new ArrayList<>();

        if(isPrime(number)) {
            result.add(number);
            return result;
        }

        Long test = number;
        int i = 0;
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
            add(2L);
        }
        return get(size() - 1);
    }

    public Long pop() {
        Long value = largestPrime();
        remove(size() - 1);
        return value;
    }
}
