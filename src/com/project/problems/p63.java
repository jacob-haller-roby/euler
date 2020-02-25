package com.project.problems;

import com.project.base.ProblemBase;

import java.math.BigInteger;

public class p63 extends ProblemBase {

    public Long execute() {
        int count = 0;
        int power = 1;
        int matches;
        do {

            int i = 1;
            matches = 0;
            while(true) {
                String powString = String.valueOf(BigInteger.valueOf(i).pow(power));
                int length = powString.length();
                if(length == power) {
                    matches++;
                    System.out.println("Match: " + powString + " = " + i + "^" + power);
                }

                if (length > power) {
                    break;
                }
                i++;
            }

            count += matches;

            power++;

        } while(matches > 0);

        return (long) count;
    }
}
