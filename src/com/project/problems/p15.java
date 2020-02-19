package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;

public class p15 extends ProblemBase {

    private static int size = 20;

    public Long execute() {
        ArrayList<ArrayList<Long>> grid = new ArrayList<>();
        grid.add(new ArrayList<>());
        grid.get(0).add(1l);

        for(int i = 0; i < size; i++) {
            //rows
            grid.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                //nodes
                Long value = grid.get(i).get(j);
                if (grid.get(i+1).size() < j+1) {
                    grid.get(i+1).add(j, value);
                } else {
                    grid.get(i+1).set(j, grid.get(i+1).get(j) + value);
                }

                grid.get(i+1).add(j+1, value);
            }
        }

        Long result = grid.get(grid.size() - 1).stream().mapToLong(n -> (long) Math.pow(n, 2)).sum();
        return result;

    }
}
