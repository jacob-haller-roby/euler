package com.project.problems;

import com.project.base.ProblemBase;

public class p44 extends ProblemBase {


    public Long execute() {


        for(long k = 1; ; k++) {
            long pk = getPentagonal(k);
            for(long j = k-1; j > 0; j--) {
                long pj = getPentagonal(j);
                long s = pj  + pk;
                long d = pk - pj;

                if(isPentagonal(d) && isPentagonal(s)){
                    return d;
                }
            }
        }




    }

    public boolean isPentagonal(long number) {
        return 0 == ((1+Math.sqrt(1+24*number)) / 6) % 1;
    }

    public long getPentagonal(long n) {
        return n*(3*n-1) / 2;
    }
}
