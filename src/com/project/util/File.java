package com.project.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File extends ArrayList<String> {
    public File(String name) {
        try {
            addAll(Files.readAllLines(getFilePath(name)));
        } catch (Exception e) {
            System.err.println("ERROR reading file " + name);
        }
    }

    public static Path getFilePath(String name) {
        name = "resources/" + name;
        if (!name.endsWith(".txt")){
            name += ".txt";
        }
        return Paths.get(name);
    }

    public static boolean exists(String name) {
        return Files.exists(getFilePath(name));
    }

}
