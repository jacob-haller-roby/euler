package com.project.problems;

import com.project.util.Pandigital;
import com.project.util.ProblemBase;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p38 extends ProblemBase {

    public Long execute() {
        ArrayList<Long> pandigitals = getConcatPandigitals();
        return pandigitals.stream().max(Long::compareTo).orElse(0l);
    }

    public ArrayList<Long> getConcatPandigitals() {

        ArrayList<Long> pandigitals = new ArrayList<>();

        for (int i = 1; i < 99999; i++) {
            ArrayList<Integer> products = new ArrayList<>();
            products.add(i);
            for(int j = 2; ; j++) {
                products.add(i*j);
                String concat = products.stream().map(Object::toString).collect(Collectors.joining());

                if(concat.length() > 9) {
                    break;
                }

                if(Pandigital.isPandigital(concat)) {
                    pandigitals.add(Long.valueOf(concat));
                }

            }
        }

        return pandigitals;
    }
}
