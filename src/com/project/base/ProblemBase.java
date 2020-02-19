package com.project.base;

import com.project.util.File;
import com.project.util.FileQuotedList;
import com.project.util.Primes;
import com.project.util.Timer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Queue;

public abstract class ProblemBase {

    protected static Primes primes = new Primes();
    protected String name;
    protected Timer timer = new Timer();

    protected FileQuotedList words;

    public String getName() {
        return name;
    }

    public abstract Long execute();

    public ProblemBase() {
        name = this.getClass().getSimpleName().replace("p","");
        if(File.exists(name)) {
            words = new FileQuotedList(name);
        }
    }
}
