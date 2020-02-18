package com.project.problems;

import com.project.util.Fib;
import com.project.util.ProblemBase;


public class p2 extends ProblemBase {

    public Long execute() {
        Fib fib = new Fib();
        Long sum = 0l;
        for(int i = fib.next(); i < 4000000; i = fib.next()) {
            if(i % 2 == 0) {
                sum += i;
            }
        }

        return sum;

    }

}
