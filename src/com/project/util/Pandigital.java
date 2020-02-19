package com.project.util;

public class Pandigital {
    public static boolean isPandigital(Long number) {
        return isPandigital(number.toString());
    }

    public static boolean isPandigital(Integer number) {
        return isPandigital(number.toString());
    }

    public static boolean isPandigital(String string) {
        return string.matches("(?:([1-9])(?!.*\\1)){9}");
    }
}
