package com.project.util;

import java.util.ArrayList;

public class Permutations {
    static public ArrayList<Long> transform(Long number) {
        ArrayList<Integer> digits = new CharArray(number.toString()).toInts();
        return transform(digits, digits.size());
    }

    // a = digits
    //return = array of numbers
    private static ArrayList<Long> transform(ArrayList<Integer> digits, int size) {
        //int size = a.size();
        ArrayList<Long> result = new ArrayList<>();

        if(size == 0) {
            Long number = digits.stream().mapToLong(Integer::longValue).reduce( 0, (acc, cur) -> acc * 10 + cur);
            result.add(number);
            return result;
        }

        for (int i = 0; i < size; i++) {
            result.addAll(transform(digits, size - 1));

            if (size %2 ==1) {
                int tmp = digits.get(0);
                digits.set(0, digits.get(size - 1));
                digits.set(size - 1, tmp);
            } else {
                int tmp = digits.get(i);
                digits.set(i, digits.get(size - 1));
                digits.set(size - 1, tmp);
            }
        }

        return result;

    }


}
