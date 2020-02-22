package com.project.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayNumber extends ArrayList<Integer> implements Comparable {

    public ArrayNumber clone() {
        ArrayNumber clone = new ArrayNumber();
        clone.set(this);
        return clone;
    }

    private boolean positive = true;
    public boolean getPositive() {
        return positive;
    }
    public Integer digitSum() {
        return stream().mapToInt(Integer::intValue).sum();
    }

    public String print() {
        return (positive ? "" : "-") + stream().map(Objects::toString).reduce("", (acc, cur) -> cur + acc);
    }

    public String print(int start, int end) {
        return IntStream.range(start, end).map(this::get).mapToObj(Objects::toString).reduce("", (acc, cur) -> cur + acc);
    }

    public ArrayNumber truncate(int start, int end) {
        int trueEnd = Math.min(size(), end);
        List<Integer> holder = new ArrayList<>(subList(start, trueEnd));
        clear();
        addAll(holder);
        return this;
    }

    public Long toLong() {
        return Long.valueOf(print());
    }

    public boolean greaterThan(ArrayNumber n) {
        if(positive && !n.getPositive()) return true;
        if(!positive && n.getPositive()) return false;

        if(size() != n.size()) return positive ? size() > n.size() : size() < n.size();
        for(int d = size() - 1; d >= 0; d--) {
            if(!get(d).equals(n.get(d))) return positive ? get(d) > n.get(d) : get(d) < n.get(d);
        }
        return false;
    }

    public boolean lessThan(ArrayNumber n) {
        if(positive && !n.getPositive()) return false;
        if(!positive && n.getPositive()) return true;

        if(size() != n.size()) return positive ? size() < n.size() : size() > n.size();
        for(int d = size() - 1; d >= 0; d--) {
            if(!get(d).equals(n.get(d))) return positive ? get(d) < n.get(d) : get(d) > n.get(d);
        }
        return false;
    }

    public boolean lessThan(int i){
        ArrayNumber n = new ArrayNumber();
        n.setToInt(i);
        return lessThan(n);
    }

    public boolean greaterThan(long i) {
        ArrayNumber n = new ArrayNumber();
        n.setToInt(i);
        return greaterThan(n);
    }

    public boolean greaterThan(int i){
        return greaterThan((long) i);
    }

    public boolean equals(ArrayNumber n) {
        if(size() != n.size()) return false;
        for(int d = size() - 1; d >= 0; d--) {
            if(!get(d).equals(n.get(d))) return false;
        }
        return true;
    }

    public void setToInt(int num) {
        setToInt((long) num);
    }

    public void setToInt(long num) {
        //System.out.println("Clearing values");
        clear();
        if(num < 0) {
            num = 0-num;
            positive = false;
        } else {
            positive = true;
        }
        add(num);
        //System.out.println("New Value: " + this);
    }

    public void set(ArrayNumber num) {
        clear();
        addAll(num);
        positive = num.positive;
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

    public ArrayNumber add(ArrayNumber num) {
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

        return this;
    }

    public ArrayNumber add(int num) {
        return add((long) num);
    }

    public ArrayNumber add(long num) {
        long carryOver = num;
        for(int i = 0; carryOver > 0; i++) {
            carryOver += get(i);
            set(i, (int) (carryOver % 10));
            carryOver /= 10;
        }
        return this;
    }

    public ArrayNumber subtract(int num) {
        ArrayNumber s = new ArrayNumber();
        s.setToInt(num);
        subtract(s);
        return this;
    }

    public ArrayNumber subtract(ArrayNumber num) {

        ArrayNumber holder = new ArrayNumber();
        if(lessThan(num)) {
            holder.set(this);
            set(num);
            positive = !positive;
        } else {
            holder.set(num);
        }

        int carryOver = 0;
        int maxLength = Math.max(holder.size(), size());
        for(int i = 0; i < maxLength; i++) {

            int value = get(i) - holder.get(i) + carryOver;
            if (value < 0) {
                value += 10;
                carryOver = -1;
            } else {
                carryOver = 0;
            }
            value %= 10;
            set(i, value);

        }

        while(carryOver != 0) {
            super.add(carryOver%10);
            carryOver /= 10;
        }

        trim();
        return this;
    }

    private void trim() {
        for(int i = size()-1; i >=0; i--) {
            if(get(i) == 0) {
                remove(i);
            } else {
                return;
            }
        }
    }

    public ArrayNumber multiply(int num) {
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

        return this;
    }

    public ArrayNumber multiply(ArrayNumber num) {
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
        set(holder);
        positive = positive == num.positive;
        return this;
    }

    public boolean isDivisibleBy(int n) {
        ArrayNumber test = clone();
        test.divide(n);
        test.multiply(n);
        return equals(test);
    }

    public ArrayNumber divide(int n ) {
        int carryOver = 0;
        for(int i = size()-1; i >= 0; i--) {
            carryOver *=10;
            carryOver += get(i);
            if(carryOver >= n) {
                set(i, carryOver / n);
                carryOver %= n;
            } else {
                set(i, 0);
            }
        }

        trim();
        return this;
    }

    public void square() {
        multiply(this);
    }

    //subtract 1
    public void reduce() {
        subtract(1);
    }

    @Override
    public int compareTo(Object o) {
        if(greaterThan((ArrayNumber) o)) return 1;
        else if(equals(o)) return 0;
        return -1;
    }
}
