package com.project.problems;

import com.project.base.ProblemBase;
import com.project.util.CharArray;
import com.project.util.TriangleNumbers;

public class p42 extends ProblemBase {

    TriangleNumbers triangleNumbers = new TriangleNumbers();

    public Long execute() {
        return words.stream()
                .map(word -> (new CharArray(word)).stream().mapToLong(character -> character - 64).sum())
                .filter(wordValue -> triangleNumbers.isTriangle(wordValue))
                .count();
    }
}
