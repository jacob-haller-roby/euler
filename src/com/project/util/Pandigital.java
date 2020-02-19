package com.project.util;

public class Pandigital {
    public static boolean isPandigital(Long number) {
        return isPandigital(number.toString());
    }

    public static boolean isPandigital(Integer number) {
        return isPandigital(number.toString());
    }

    public static boolean isPandigital(String string) {
        return isPandigitalN(string, 9);
    }


    public static boolean isPandigitalN(Long number) {
        return isPandigitalN(number.toString());
    }

    public static boolean isPandigitalN(Integer number) {
        return isPandigitalN(number.toString());
    }

    public static boolean isPandigitalN(String string) {
        return isPandigitalN(string, string.length());
    }


    public static boolean isPandigitalN(String string, int n) {
        return string.matches("(?:([1-" + n + "])(?!.*\\1)){" + n + "}");
    }
}
