package com.project.problems;

import com.project.base.ProblemBase;

public class p45 extends ProblemBase {

    public Long execute() {
        long n = 144;
        long N = n*(2*n-1);
        while(!isTriangle(N) || !isPentagonal(N) || !isHexagonal(N)){
            n++;
            N = n*(2*n-1);
        }
        return N;
    }

    public boolean isTriangle(long number) {
        //n^2 + n - 2N
        //1, 1, - 2N
        long a = 1, b = 1, c = -2 * number;;
        return wholeNumberQuadratic(a, b, c);
    }

    public boolean isPentagonal(long number) {
        //3n^2 - n - 2N
        //3, -1, -2
        long a = 3, b = -1, c = -2 * number;;
        return wholeNumberQuadratic(a, b, c);
    }

    public boolean isHexagonal(long number) {
        //2n^2 - n - N
        //2, -1, -1
        long a = 2, b = -1, c = -number;;
        return wholeNumberQuadratic(a, b, c);
    }

    public boolean wholeNumberQuadratic(long a, long b, long c) {
        double quadratic = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);

        return quadratic == Math.floor(quadratic);
    }
}
