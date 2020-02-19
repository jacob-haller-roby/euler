package com.project.base;

import com.project.util.Primes;
import com.project.util.Timer;

public abstract class ProblemBase {

    protected static Primes primes = new Primes();
    protected String name;
    protected Timer timer = new Timer();
    public String getName() {
        return name;
    }

    public abstract Long execute();

    public ProblemBase() {
        name = this.getClass().getSimpleName().replace("p","");
    }
}
