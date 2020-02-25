package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Permutations;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class p61 extends ProblemBase {

    public Long execute() {
        ArrayList<Long> triangles = new ArrayList<>(); //n(n+1)/2
        ArrayList<Long> squares = new ArrayList<>(); //n^2
        ArrayList<Long> pentagonals = new ArrayList<>(); //n(3n-1)/2
        ArrayList<Long> hexagonals = new ArrayList<>(); //n(2n-1)
        ArrayList<Long> heptagonals = new ArrayList<>(); //n(5n-3)/2
        ArrayList<Long> octagonals = new ArrayList<>(); //n(3n-2)

        for(int i = 1; ;i++) {
            long triangle = getTriangle(i);
            if(triangle < 1000) continue;
            if(triangle > 9999) break;
            triangles.add(triangle);
        }

        for(int i = 1; ;i++) {
            long square = getSquare(i);
            if(square < 1000) continue;
            if(square > 9999) break;
            squares.add(square);
        }

        for(int i = 1; ;i++) {
            long pentagonal = getPentagonal(i);
            if(pentagonal < 1000) continue;
            if(pentagonal > 9999) break;
            pentagonals.add(pentagonal);
        }

        for(int i = 1; ;i++) {
            long hexagonal = getHexagonal(i);
            if(hexagonal < 1000) continue;
            if(hexagonal > 9999) break;
            hexagonals.add(hexagonal);
        }

        for(int i = 1; ;i++) {
            long heptagonal = getHeptagonal(i);
            if(heptagonal < 1000) continue;
            if(heptagonal > 9999) break;
            heptagonals.add(heptagonal);
        }

        for(int i = 1; ;i++) {
            long octagonal = getOctagonal(i);
            if(octagonal < 1000) continue;
            if(octagonal > 9999) break;
            octagonals.add(octagonal);
        }

        ArrayList<Long> order = new ArrayList(Arrays.asList(0l,1l,2l,3l,4l,5l));

        ArrayList<ArrayList<Long>> orders = Permutations.transformLongArray(order);
        ArrayList<ArrayList<Long>> values = new ArrayList<>(Arrays.asList(triangles, squares, pentagonals, hexagonals, heptagonals, octagonals));

        return searchForAnswer(values, orders);
    }

    public Long searchForAnswer(ArrayList<ArrayList<Long>> values, ArrayList<ArrayList<Long>> orders) {
        return orders.stream()
                .map(order -> searchForOrderAnswer(values, order))
                .filter(i -> i > 0)
                .findAny()
                .orElse(0L);
    }

    public Long searchForOrderAnswer(ArrayList<ArrayList<Long>> values, ArrayList<Long> order) {
        for (Long a: values.get(order.get(0).intValue())) {
            for (Long b : values.get(order.get(1).intValue())) {
                if (b % 100 != a / 100) continue;
                for (Long c : values.get(order.get(2).intValue())) {
                    if (c % 100 != b / 100) continue;
                    for (Long d : values.get(order.get(3).intValue())) {
                        if (d % 100 != c / 100) continue;
                        for (Long e : values.get((order.get(4).intValue()))) {
                            if (e % 100 != d / 100) continue;
                            for (Long f : values.get((order.get(5).intValue()))) {
                                if (f % 100 != e / 100) continue;
                                if (a % 100 != f / 100) continue;
                                return a + b + c + d + e + f;
                            }
                        }
                    }
                }
            }
        }
        return 0L;
    }

    public ArrayList<Long> getLastDigits(ArrayList<Long> list) {
        return list.stream().map(i -> i%100).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<Long> getFirstDigits(ArrayList<Long> list) {
        return list.stream().map(i -> i/100).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Long getTriangle(int n){
        return (long) n * (n+1) / 2;
    }

    public Long getSquare(int n) {
        return (long) Math.pow(n,2);
    }

    public Long getPentagonal(int n) {
        return (long) n * (3*n - 1) / 2;
    }

    public Long getHexagonal(int n) {
        return (long) n * (2 * n - 1);
    }

    public Long getHeptagonal(int n ) {
        return (long) n * (5*n-3) / 2;
    }

    public Long getOctagonal(int n) {
        return (long) n * (3 * n - 2);
    }
}
