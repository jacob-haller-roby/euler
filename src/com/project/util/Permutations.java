package com.project.util;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Permutations {
    static public ArrayList<Long> transform(Long number) {
        ArrayList<Integer> digits = new CharArray(number.toString()).toInts();
        return transform(digits, digits.size());
    }

    // a = digits
    //return = array of numbers
    public static ArrayList<Long> transform(ArrayList<Integer> digits, int size) {
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

    public static ArrayList<ArrayList<Long>> transformLongArray(ArrayList<Long> numbers) {
        return transformLongArray(numbers, numbers.size());
    }

    public static ArrayList<ArrayList<Long>> transformLongArray(ArrayList<Long> numbers, int size) {

        ArrayList<ArrayList<Long>> result = new ArrayList<>();

        if(size == 0) {
            result.add(numbers);
            return result;
        }

        for (int i = 0; i < size; i++) {
            numbers = new ArrayList<>(numbers);
            result.addAll(transformLongArray(numbers, size - 1));

            if (size %2 ==1) {
                long tmp = numbers.get(0);
                numbers.set(0, numbers.get(size - 1));
                numbers.set(size - 1, tmp);
            } else {
                long tmp = numbers.get(i);
                numbers.set(i, numbers.get(size - 1));
                numbers.set(size - 1, tmp);
            }
        }

        return result;

    }

    static public ArrayList<String> transform(String string) {
        CharArray characters = new CharArray(string);
        return transform(characters, characters.size());
    }

    private static ArrayList<String> transform(CharArray characters, int size) {
        //int size = a.size();
        ArrayList<String> result = new ArrayList<>();

        if(size == 0) {
            String string = characters.stream()
                    .map(character -> Character.toString(character))
                    .collect(Collectors.joining(""));
            result.add(string);
            return result;
        }

        for (int i = 0; i < size; i++) {
            result.addAll(transform(characters, size - 1));

            if (size %2 ==1) {
                char tmp = characters.get(0);
                characters.set(0, characters.get(size - 1));
                characters.set(size - 1, tmp);
            } else {
                char tmp = characters.get(i);
                characters.set(i, characters.get(size - 1));
                characters.set(size - 1, tmp);
            }
        }

        return result;

    }


}
