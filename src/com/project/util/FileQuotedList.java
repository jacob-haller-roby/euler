package com.project.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileQuotedList extends File {
    public FileQuotedList(String name) {
        super(name);
        String[] words = get(0).replace("\"", "").split(",");
        clear();
        addAll(Arrays.stream(words).map(String::trim).collect(Collectors.toList()));
    }
}
