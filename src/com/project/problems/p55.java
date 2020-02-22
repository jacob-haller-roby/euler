package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Palindrome;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class p55 extends ProblemBase {

    public Long execute() {

        return LongStream.range(1,10000)
                .filter(n -> {
                    BigInteger nBig = BigInteger.valueOf(n);
                    for(int i = 0; i < 50; i++) {
                        nBig = reverseAndAdd(nBig);
                        if(Palindrome.isPalindrome(nBig.toString())){
                            return false;
                        }
                    }
                    return true;
                })
                .count();
    }

    public BigInteger reverseAndAdd(BigInteger n) {
        StringBuilder nString = new StringBuilder(n.toString());
        nString.reverse();
        BigInteger reversed = new BigInteger(String.valueOf(nString));
        return reversed.add(n);
    }
}
