package com.project.problems;

import com.project.base.ProblemBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class p59 extends ProblemBase {

    static ArrayList<Integer> safeCharacters = new ArrayList<>();

    public void init() {
        IntStream.range(32, 42).forEach(safeCharacters::add);
        IntStream.range(43, 123).forEach(safeCharacters::add);
    }

    public Long execute() {

        init();
        AtomicLong decodedSum = new AtomicLong();


        IntStream.range(97,122).anyMatch(a ->
            IntStream.range(97,122).anyMatch(b ->
                IntStream.range(97,122).anyMatch(c -> {
                    long sum = 0;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < words.size(); i++) {
                        int key;
                        switch (i % 3) {
                            case 0:
                                key = a;
                                break;
                            case 1:
                                key = b;
                                break;
                            case 2:
                            default:
                                key = c;
                                break;
                        }

                        int decoded = key ^ Integer.parseInt(words.get(i));
                        if(!safeCharacters.contains(decoded)) {
                            return false;
                        }
                        sum += decoded;
                        sb.append(Character.valueOf((char) decoded));
                    }
                    System.out.println(sb);
                    decodedSum.set(sum);
                    return true;
                })
            )
        );

        return decodedSum.get();
    }
}
