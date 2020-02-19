package com.project.problems;

import com.project.util.CharArray;
import com.project.base.ProblemBase;

import java.util.stream.IntStream;

public class p17 extends ProblemBase {

    static Integer upper = 1000;

    public Long execute() {

        int sum = IntStream.range(1, upper + 1).map(i -> {
            String word = wordify(i);
            CharArray characters = new CharArray(word.replace(" ", ""));
            Integer count = characters.size();
            System.out.println(word + " : " + count);
            return count;
        }).sum();

        return Long.valueOf(sum);
    }

    private static String wordify(Integer i) {
        Integer ones = i % 10;
        Integer tens = (i % 100) / 10;
        Integer hundreds = (i % 1000) / 100;
        Integer thousands = (i % 10000) / 1000;

        String onesString = "";
        String tensString = "";
        String hundredsString = "";
        String thousandsString = "";
        String joiningAnd = "";

        switch (ones) {
            case 1:
                onesString = "one";
                break;
            case 2:
                onesString = "two";
                break;
            case 3:
                onesString = "three";
                break;
            case 4:
                onesString = "four";
                break;
            case 5:
                onesString = "five";
                break;
            case 6:
                onesString = "six";
                break;
            case 7:
                onesString = "seven";
                break;
            case 8:
                onesString = "eight";
                break;
            case 9:
                onesString = "nine";
                break;
            case 0:
                onesString = "";
        }

        switch (tens) {
            case 1:
                tensString = "";
                switch(ones) {
                    case 1:
                        onesString = "eleven";
                        break;
                    case 2:
                        onesString = "twelve";
                        break;
                    case 3:
                        onesString = "thirteen";
                        break;
                    case 4:
                        onesString = "fourteen";
                        break;
                    case 5:
                        onesString = "fifteen";
                        break;
                    case 6:
                        onesString = "sixteen";
                        break;
                    case 7:
                        onesString = "seventeen";
                        break;
                    case 8:
                        onesString = "eighteen";
                        break;
                    case 9:
                        onesString = "nineteen";
                        break;
                    case 0:
                        onesString = "ten";
                }
                break;
            case 2:
                tensString = "twenty";
                break;
            case 3:
                tensString = "thirty";
                break;
            case 4:
                tensString = "forty";
                break;
            case 5:
                tensString = "fifty";
                break;
            case 6:
                tensString = "sixty";
                break;
            case 7:
                tensString = "seventy";
                break;
            case 8:
                tensString = "eighty";
                break;
            case 9:
                tensString = "ninety";
                break;
            case 0:
                tensString = "";
        }

        switch (hundreds) {
            case 1:
                hundredsString = "one hundred";
                break;
            case 2:
                hundredsString = "two hundred";
                break;
            case 3:
                hundredsString = "three hundred";
                break;
            case 4:
                hundredsString = "four hundred";
                break;
            case 5:
                hundredsString = "five hundred";
                break;
            case 6:
                hundredsString = "six hundred";
                break;
            case 7:
                hundredsString = "seven hundred";
                break;
            case 8:
                hundredsString = "eight hundred";
                break;
            case 9:
                hundredsString = "nine hundred";
                break;
            case 0:
                hundredsString = "";
                break;
        }

        if(
            (thousands != 0 || hundreds != 0)  &&
                    (tens != 0 || ones != 0)
        ) {
            joiningAnd = "and ";
        }

        switch (thousands) {
            case 1:
                thousandsString = "one thousand";
                break;
            case 0:
                thousandsString = "";
                break;
        }

        return thousandsString + " " + hundredsString + " " + joiningAnd +tensString + " " + onesString;

    }
}
