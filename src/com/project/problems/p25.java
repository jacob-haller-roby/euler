package com.project.problems;

import com.project.util.ArrayNumber;
import com.project.util.Fib;
import com.project.util.ProblemBase;

public class p25 extends ProblemBase {

    public Long execute() {
        Long result = 3l;
        ArrayNumber a = new ArrayNumber();
        ArrayNumber b = new ArrayNumber();
        a.setToInt(1);
        b.setToInt(2);

        while(b.size() < 1000) {
            fibify(a,b);
            result++;
        }

        return result;
    }

    public void fibify(ArrayNumber a, ArrayNumber b) {
        ArrayNumber c = new ArrayNumber();
        c.set(a);
        c.add(b);
        //System.out.println(a + " + " + b + " = " + c);
        a.set(b);
        b.set(c);

    }
}
