package com.project.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayNumber extends ArrayList<Integer> {
    private boolean positive = true;
    public Integer digitSum() {
        return stream().mapToInt(Integer::intValue).sum();
    }

    public String print() {
        return stream().map(Objects::toString).reduce(positive ? "" : "-", (acc, cur) -> cur + acc);
    }

    public void setToInt(int num) {
        //System.out.println("Clearing values");
        clear();
        add(num);
        //System.out.println("New Value: " + this);
    }

    public void set(ArrayNumber num) {
        clear();
        addAll(num);
    }

    public Integer get(int i) {
        if (size() <= i) {
            return 0;
        }
        return super.get(i);
    }

    public Integer set(int i, Integer value) {
        Integer oldValue = 0;
        if (size() <= i) {
            oldValue = get(i);
            super.add(value);
        } else {
            super.set(i, value);
        }
        return oldValue;
    }

    public void add(ArrayNumber num) {
        int carryOver = 0;
        int maxLength = Math.max(num.size(), size());
        for(int i = 0; i < maxLength; i++) {

            int value = num.get(i) + get(i) + carryOver;
            carryOver = value / 10;
            value %= 10;
            set(i, value);

        }

        while(carryOver != 0) {
            super.add(carryOver%10);
            carryOver /= 10;
        }
    }

    public void add(int num) {
        int carryOver = num;
        for(int i = 0; carryOver > 0; i++) {
            carryOver += get(i);
            set(i, carryOver % 10);
            carryOver /= 10;
        }
    }

    public void multiply(int num) {
        int carryOver = 0;
        for(int i = 0; i < size(); i++) {
            carryOver += get(i) * num;
            set(i, carryOver % 10);
            carryOver /= 10;
        }
        while(carryOver > 0) {
            super.add(carryOver % 10);
            carryOver /= 10;
        }
    }

    public void multiply(ArrayNumber num) {
        ArrayNumber holder = new ArrayNumber();
        int carryOver = 0;
        for(int i = 0; i < num.size(); i++){
            for(int j = 0; j < size(); j++){
                int value = num.get(i)*get(j) + carryOver;
                int index = i+j;
                int prev = holder.size() > index ? holder.get(index) : 0;
                value += prev;
                holder.set(index, value%10);
                carryOver = value/10;
            }
            int index = num.size() + i;
            while(carryOver > 0){
                int prev = holder.size() > index ? holder.get(index) : 0;
                int value = prev + carryOver;
                holder.set(index, value%10);
                carryOver /= 10;
            }
        }
        this.set(holder);
    }

    public void square() {
        multiply(this);
    }

    //subtract 1
    public void reduce() {
        int carryOver = 1;
        int index = 0;
        while(carryOver > 0) {
            int value = get(index) - carryOver;
            carryOver = 0;

            if(value < 0) {
                value +=10;
                carryOver = 1;
            }

            set(index, value);
        }

    }
}
