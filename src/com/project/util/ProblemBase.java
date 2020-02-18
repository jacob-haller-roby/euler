package com.project.util;

public abstract class ProblemBase {

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
