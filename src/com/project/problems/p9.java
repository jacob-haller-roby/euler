package com.project.problems;

import com.project.base.ProblemBase;

import java.util.stream.LongStream;

public class p9 extends ProblemBase {

    public Long execute() {

        //sqrt(a^2 + b^2) = 1000 - a - b;
        //b = (1000(a-500))/(a-1000);
        return LongStream.range(1,500).map(a -> {
            double b = (1000 * (a-500))/(a-1000);
            if(isInt(b)) {
                double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if(isInt(c)) {
                    int sum = (int) (a + b + c);
                    System.out.println("INTEGERS: " + a + " " + b + " " + c + " - " + sum);
                    //BigInteger product = BigInteger.valueOf(a).multiply(BigInteger.valueOf((int)b)).multiply(BigInteger.valueOf((int)c));
                    return (long) (a * b * c);
                }
            }
            return 0;
        }).filter(a -> a != 0).findFirst().orElse(0l);

    }

    public static boolean isInt(double i) {
        return i == (int) i;
    }
}
