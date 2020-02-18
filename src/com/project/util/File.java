package com.project.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File extends ArrayList<String> {
    public File(String name) {
        name = "resources/" + name;
        if (!name.endsWith(".txt")){
            name += ".txt";
        }
        try {
            addAll(Files.readAllLines(Paths.get(name)));
        } catch (Exception e) {
            System.err.println("ERROR reading file " + name);
        }
    }
}
