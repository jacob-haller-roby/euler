package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.Timer;

import java.util.Scanner;

public class Launcher {

    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();

    public static void main(String[] args) {

        ProblemBase problem = null;

        while (problem == null) {
            System.out.println("Select Problem Number:");
            String input = scanner.nextLine();

            try {
                Class c = Class.forName("com.project.problems.p" + input);
                problem = (ProblemBase) c.getConstructor().newInstance();
            } catch (Exception e) {
                System.err.println("Problem not found.  Try again.");
            }
        }

        System.out.println();
        System.out.println("Running Problem #"  + problem.getName());
        timer.start();
        System.out.println("The answer is: "  +  problem.execute());
        timer.stop("Completed in ");
    }

}
