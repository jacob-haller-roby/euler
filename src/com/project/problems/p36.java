package com.project.problems;

import com.project.util.Palindrome;
import com.project.util.ProblemBase;

import java.util.stream.LongStream;

public class p36 extends ProblemBase {

    static Integer limit = 1000000;

    public Long execute() {
        return LongStream.range(0, limit).filter(i -> Palindrome.isPalindrome(i) && Palindrome.isPalindrome(Long.toBinaryString(i))).sum();
    }
}
