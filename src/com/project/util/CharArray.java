package com.project.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CharArray extends ArrayList<Character> {
    public CharArray(String string) {
        super();
        List<Character> characters = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        this.addAll(characters);
    }

    public ArrayList<Integer> toInts() {
        return new ArrayList<>(stream().map(i -> Integer.valueOf(i.toString())).collect(Collectors.toList()));
    }
}
