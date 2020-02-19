package com.project.util;

import java.util.stream.IntStream;

public class Palindrome {
    static public boolean isPalindrome(Long number) {
        return isPalindrome(number.toString());
    }

    static public boolean isPalindrome(Integer number) {
        return isPalindrome(number.toString());
    }

    static public boolean isPalindrome(String string) {
        CharArray characters = new CharArray(string);
        int size = characters.size();

        return IntStream.range(0, (characters.size() / 2) + 1).allMatch(i ->
                characters.get(i) == characters.get(size - 1 - i)
        );
    }
}
