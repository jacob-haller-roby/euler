package com.project.problems;

import com.project.util.CharArray;
import com.project.util.File;
import com.project.util.ProblemBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class p22 extends ProblemBase {



    public Long execute() {
        File file = new File("twentytwo");
        //File file = new File("twentytwo_test");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(file.get(0).replace("\"", "").split(",")));
        names.sort(String::compareTo);

        Integer sum = IntStream.range(0,names.size())
                .map(i -> (i+1) * score(names.get(i).trim()))
                .sum();
        return Long.valueOf(sum);
    }

    public static Integer score(String name) {
        CharArray characters = new CharArray(name);
        Integer score = characters.stream().mapToInt(p22::score).sum();
        System.out.println(name + " score is: " + score);
        return score;
    }

    public static Integer score(char c) {
        return (int) c - 64;
    }
}
