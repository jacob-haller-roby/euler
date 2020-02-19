package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p4 extends ProblemBase {

    public Long execute() {
        Long palindrome = getNumbers().stream().filter(i -> isPalindrome(i)).findFirst().orElse(null);
        return palindrome;
    }

    public static ArrayList<Long> getNumbers() {
        ArrayList<Long> numbers = new ArrayList<>();
        for(int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                numbers.add((long) j * i);
            }
        }
        numbers.sort(Long::compareTo);
        Collections.reverse(numbers);
        return numbers;
    }

    public static boolean isPalindrome(long number) {
        String string = String.valueOf(number);
        Integer size = string.length();
        List<Character> characters = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for(int i = 0; i < size / 2; i++) {
            if(characters.get(i) != characters.get(size - 1 - i)) return false;
        }
        return true;
    }
}
