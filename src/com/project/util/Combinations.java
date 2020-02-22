package com.project.util;

import java.util.*;
import java.util.stream.Collectors;

public class Combinations {

    public static ArrayList<ArrayList<Long>> getCombinations(List<Long> input, int size) {
        //recursive

        if(size == 1) {
            return input.stream().map(item -> {
                ArrayList<Long> i = new ArrayList<>();
                i.add(item);
                return i;
            }).collect(Collectors.toCollection(ArrayList::new));
        }

        ArrayList<ArrayList<Long>> combinations = getCombinations(input, size - 1);
        Set<ArrayList<Long>> newCombinations = new HashSet<>();

        combinations.forEach(c ->
            newCombinations.addAll(
                    new ArrayList<>(
                            input.stream()
                        .filter(item -> !c.contains(item))
                        .map(item -> {
                            ArrayList<Long> result = new ArrayList<>(c);
                            result.add(item);
                            result.sort(new ToStringComparator());
                            return result;
                        })
                        .collect(Collectors.toList())
                    )
            )
        );

        return new ArrayList<>(newCombinations);

    }

    static class ToStringComparator implements Comparator {

        @Override
        public int compare(Object o, Object t1) {
            return o.toString().compareTo(t1.toString());
        }
    }



}
