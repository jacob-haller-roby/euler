package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;

public class p12 extends ProblemBase {

    private static ArrayList<Long> triangles = new ArrayList<>();

    public Long execute() {
        ArrayList<Long> divisors = new ArrayList<>();
        Long triangle = getNextTriangle();
        while(divisors.size() < 500) {
            triangle = getNextTriangle();
            divisors = getFactors(triangle);
        }

        return triangle;
    }

    public static Long getNextTriangle() {
        Long triangle;
        if(triangles.isEmpty()) {
            triangle = 1l;
        } else {
            triangle = triangles.size() + 1 + triangles.get(triangles.size() - 1);
        }
        triangles.add(triangle);
        return triangle;
    }

    public static ArrayList<Long> getFactors(Long triangle) {
        ArrayList<Long> results = new ArrayList<>();
        Long upperBound = triangle;
        for (Long i = 2l; i < upperBound; i++) {
            if( triangle % i == 0 ) {
                results.add(i);
                upperBound = triangle / i;
                if(upperBound != i) {
                    results.add(upperBound);
                }
            }
        }
        return results;
    }

}
