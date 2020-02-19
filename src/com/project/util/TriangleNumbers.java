package com.project.util;

import java.util.ArrayList;

public class TriangleNumbers extends ArrayList<Long> {
    public void fillBelow(Long i) {
        while(largestTriangle() < i) getNextTriangle();
        pop();
    }

    public void fillAbove(Long i) {
        while(largestTriangle() < i) getNextTriangle();
    }

    public Long largestTriangle() {
        if(isEmpty()) getNextTriangle();
        return get(size() - 1);
    }

    public Long pop() {
        Long value = largestTriangle();
        remove(size()-1);
        return value;
    }

    public Long getNextTriangle() {
        int n = size() + 1;
        add((long) (n * (n+1) / 2));
        return largestTriangle();
    }

    public boolean isTriangle(Long number) {
        fillAbove(number);
        return contains(number);
    }
}
