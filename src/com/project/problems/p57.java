package com.project.problems;

import com.project.base.ProblemBase;

import java.math.BigInteger;

public class p57 extends ProblemBase {

    public Long execute() {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.TWO;

        long higherNumeratorDigitCount = 0;
        for(int i = 0; i < 1000; i++) {
            if(getDigitCount(numerator.add(denominator)) > getDigitCount(denominator)){
                higherNumeratorDigitCount++;
                System.out.println((numerator.add(denominator)) + " / " + denominator);
            }

            numerator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
            BigInteger tmp = denominator;
            denominator = numerator;
            numerator = tmp;

        }

        return higherNumeratorDigitCount;
    }

    public long getDigitCount(BigInteger number) {
        return number.toString().length();
    }
    /*
    each iteration:

    start with 1/2

    nom += denom*2
    swap nom/denom

    final iteration:
    nom += denom

    iteration 1:
    1/2 -> 3/2

    iteration 2:
    1/2 -> 5/2 -> 2/5
    2/5 -> 7/5

    iteration 3:
    1/2 -> 5/2 -> 2/5
    2/5 -> 12/5 -> 5/12
    17/12

     */
}
