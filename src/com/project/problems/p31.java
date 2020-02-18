package com.project.problems;

import com.project.util.ArrayNumber;
import com.project.util.ProblemBase;

import java.util.stream.IntStream;

public class p31 extends ProblemBase {
    static int twoPound = 200;
    static int pound = 100;
    static int fifty = 50;
    static int twenty = 20;
    static int ten = 10;
    static int five = 5;
    static int two = 2;
    static int one = 1;

    public Long execute() {
        long result = 0;

        int target = 200;
        int remaining = target;

        for(int tp = 0; tp <= remaining/twoPound; tp++) {
            remaining -= tp * twoPound;
            if(remaining == 0) {
                remaining += tp*twoPound;
                result++;
                break;
            }
            for(int p = 0; p <= remaining/pound; p++) {
                remaining -= p * pound;
                if(remaining == 0) {
                    remaining += p*pound;
                    result++;
                    break;
                }
                for(int fy = 0; fy <= remaining/fifty; fy++) {
                    remaining -= fy * fifty;
                    if(remaining == 0) {
                        remaining += fy*fifty;
                        result++;
                        break;
                    }
                    for(int ty = 0; ty <= remaining/twenty; ty++) {
                        remaining -= ty* twenty;
                        if(remaining == 0) {
                            remaining += ty*twenty;
                            result++;
                            break;
                        }
                        for(int te = 0; te <= remaining/ten; te++) {
                            remaining -= te*ten;
                            if(remaining == 0) {
                                remaining += te*ten;
                                result++;
                                break;
                            }
                            for(int f = 0; f <= remaining/five; f++){
                                remaining -= f*five;
                                if(remaining == 0) {
                                    remaining += f*five;
                                    result++;
                                    break;
                                }
                                for(int t = 0; t <= remaining/two; t++){
                                    result++;
                                }
                                remaining += f*five;
                            }
                            remaining += te*ten;
                        }
                        remaining += ty * twenty;
                    }
                    remaining += fy * fifty;
                }
                remaining += p*pound;
            }
            remaining += tp * twoPound;
        }

        return result;

    }
}
