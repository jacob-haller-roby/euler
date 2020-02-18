package com.project.problems;

import com.project.util.ProblemBase;

import java.util.ArrayList;

public class p18 extends ProblemBase {

    static String input = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    public Long execute() {
        ArrayList<ArrayList<Integer>> pyramid = createPyramid();

        for(int i = pyramid.size() - 2; i >= 0; i--) {
            ArrayList<Integer> row = pyramid.get(i);
            ArrayList<Integer> previousRow = pyramid.get(i+1);
            for(int j = 0; j < row.size(); j++){
                int previousValue = row.get(j);
                int highestNode = previousRow.get(j) > previousRow.get(j+1) ? previousRow.get(j) : previousRow.get(j+1);
                row.set(j, previousValue + highestNode);
            }
        }

        Integer result = pyramid.get(0).get(0);
        return Long.valueOf(result);
    }

    public static ArrayList<ArrayList<Integer>> createPyramid() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        String[] inputs = input.split("\n");
        for(int i = 0; i < inputs.length; i++) {
            result.add(new ArrayList<>());
            String[] numbers = inputs[i].split(" ");
            for(int j = 0; j < numbers.length; j++) {
                result.get(i).add(Integer.valueOf(numbers[j]));
            }
        }
        return result;
    }
}
