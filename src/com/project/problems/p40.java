package com.project.problems;

import com.project.util.ProblemBase;

public class p40 extends ProblemBase {

    private static String string = "";
    private static Integer last = 0;

    final private static Integer power = 6;

    public Long execute() {
        long product = 1L;
        for(int i = 0; i <= power; i++) {
            int digit = (int) Math.pow(10,i);
            product *= get(digit);
        }
        return product;
    }

    private int get(int digit) {

        int digitCount = 0;
        int power = 0;
        int numberLength = power + 1;
        int range = 0;
        while(digitCount < digit) {
            range = (int) (Math.pow(10, power + 1) - Math.pow(10, power)) * numberLength;
            digitCount += range;
            power++;
            numberLength++;
        }

        digitCount -= range;
        power--;
        numberLength--;

        int i;
        digit--;
        for(i = (int) Math.pow(10, power); digitCount <= digit; digitCount += numberLength, i++);

        i--;
        digitCount -= numberLength;

        digit = digit - digitCount;
        return (int) (i / Math.pow(10,numberLength - digit - 1)) % 10;

    }
}
