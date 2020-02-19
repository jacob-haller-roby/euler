package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p24 extends ProblemBase {

    private static ArrayList<Integer> number = new ArrayList<>();
    private static ArrayList<Integer> digits = new ArrayList<Integer>(Arrays.asList(
            0,1,2,3,4,5,6,7,8,9
    ));
    private static Long position = 1000000l;

    public Long execute() {
        Long result = 0l;
        Long remainingPerms = position -1;

        ArrayList<Integer> available = new ArrayList<>();
        available.addAll(digits);

        for(int digit = 0; digit < digits.size(); digit ++) {
            int permutations = 1;
            for(int i = 1; i < digits.size() - digit; i++) permutations *= i;
            number.add(available.get((int) (remainingPerms / permutations)));
            available.remove((int) (remainingPerms /  permutations));
            remainingPerms %= permutations;
        }

        return Long.valueOf(number.stream().map(Object::toString).collect(Collectors.joining()));

    }
}
