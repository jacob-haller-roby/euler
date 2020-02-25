package com.project.problems;

import com.project.base.ProblemBase;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p65 extends ProblemBase {

    private static final int rangeBound = 10001;
    private static final int precisionStart = 100;

    /*
2 -
1; 3/1
2; 8/3
1; 11/4
1; 19/7
4; 87/32
1; 106/39
1; 193/71
6; 1264/465

8/3 = 3*2+2 / 3*1+0
11/4 = 8+3 / 3+1
19/7 = 8+11 / 3+4
87/32 = 19*4+11 / 7*4 + 4
106/39 = 87+19/ 32+7
     */
    public Long execute() {


        BigInteger prevNum = BigInteger.TWO;
        BigInteger prevDen = BigInteger.ZERO;

        BigInteger num = BigInteger.valueOf(3);
        BigInteger den = BigInteger.ONE;

        for(int i = 3; i < 101; i++) {
            BigInteger multiplier = i % 3 == 0 ? BigInteger.valueOf(i * 2 / 3) : BigInteger.ONE;

            BigInteger newNum = num.multiply(multiplier).add(prevNum);
            BigInteger newDen = den.multiply(multiplier).add(prevDen);

            prevNum = num;
            prevDen = den;
            num = newNum;
            den = newDen;
        }


        long result = 0;
        while(num.signum() > 0) {
            result += num.remainder(BigInteger.TEN).longValue();
            num = num.divide(BigInteger.TEN);
        }

        return result;

    }
}
