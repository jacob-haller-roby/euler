package com.project.util;

import java.util.ArrayList;

public class Fib extends ArrayList<Integer> {

    public Integer next() {
        Integer next;
        if (size() < 1) {
            next = 1;
        } else if (size() < 2) {
            next = 2;
        } else {
            next = get(size() - 1) + get(size() - 2);
        }

        add(next);
        return next;
    }
}
