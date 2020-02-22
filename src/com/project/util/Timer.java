package com.project.util;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

public class Timer {
    private LocalTime start;
    private LocalTime stop;
    private Duration pauseValue;

    public void start() {
        start = LocalTime.now();
    }

    public void stop() {
        stop = LocalTime.now();
        print();
    }

    public void stop(String message) {
        stop = LocalTime.now();
        print(message);
    }

    public void pause() {
        stop = LocalTime.now();
        pauseValue = Duration.between(start, stop);
    }

    public void resume() {
        start = LocalTime.now();
        if(stop != null) {
            start = start.minus(pauseValue);
        }
    }

    public void print() {
        System.out.println(Duration.between(start, stop).toMillis() + "ms");
    }

    public void print(String message) {
        System.out.println(message + " : " + Duration.between(start, stop).toMillis() + "ms");
    }
}
