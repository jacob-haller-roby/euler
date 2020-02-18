package com.project.util;

import java.util.ArrayList;

public class Factors extends ArrayList<Long> {
    public Factors() {};
    public Factors(Long num) {
        init(num);
    }
    public Factors(Integer num) {
        init((long) num);
    }

    public void set(Long num) {
        clear();
        init(num);
    }

    private void init(Long num) {
        long upperBound = (long) Math.sqrt(num);
        for(long i = 2l; i <= upperBound; i++) {
            if (num % i == 0) {
                add(i);
                if(num / i != i) {
                    add(num / i);
                }
            }
        }
        sort(Long::compare);
    }

    public Long sum() {
        return stream().mapToLong(Long::longValue).sum();
    }

    public Long properSum() {
        return sum() + 1;
    }


}
