package com.project.util;

import java.util.ArrayList;

public class Rotations {
    static public ArrayList<Long> transform(Long number) {
        ArrayList<Integer> digits = new CharArray(number.toString()).toInts();
        return transform(digits, digits.size());
    }

    private static ArrayList<Long> transform(ArrayList<Integer> digits, int size) {
        ArrayList<Long> results = new ArrayList<>();
        results.add(convertToLong(digits));
        if(size > 1) {
            digits.add(digits.remove(0));
            results.addAll(transform(digits, size - 1));
        }
        return results;
    }

    private static Long convertToLong(ArrayList<Integer> digits) {
        return digits.stream().mapToLong(Integer::longValue).reduce(0, (acc, cur) -> acc * 10 + cur);
    }


}
