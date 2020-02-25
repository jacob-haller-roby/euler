package com.project.problems;

import com.project.base.ProblemBase;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class p64 extends ProblemBase {

    private static final int rangeBound = 10001;
    private static final int precisionStart = 100;

    public Long execute() {

        return LongStream.range(2,rangeBound+1)
                .map(this::getSequenceCount)
                .filter(sequenceCount -> sequenceCount % 2 == 1)
                .count();
    }

    public long getSequenceCount(long n) {
        long sequenceCount = 0;
        for(int precision = precisionStart; sequenceCount == 0; precision += precisionStart) {

            ArrayList<Integer> digits = getDigitsWithoutFloat(n, precision);
            if(digits.size() == 0) return 0;

            sequenceCount = getSequenceCount(digits);
        }
        return sequenceCount;
    }

    public ArrayList<Integer> getDigitsWithoutFloat(long nLong, long precision) {
//      a = c`a`
//      b = c`^2 a0n - c`b`
//      c = a`^2 * n - (b - c*a0n)^2
//
//      an = (a * rad(n) + b) / c
//      a0n = int without remainder
        MathContext mc = new MathContext(5);
        ArrayList<Integer> result = new ArrayList<>();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ZERO;
        BigInteger c = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(nLong);
        BigDecimal radValue = new BigDecimal(n).sqrt(mc);
        if(BigDecimal.valueOf(radValue.intValue()).equals(radValue)) return result;

        for(int i = 0; i < precision; i++) {
            BigDecimal value = radValue.multiply(new BigDecimal(a)).add(new BigDecimal(b)).divide(new BigDecimal(c), mc);
            int digit = value.intValue();
            result.add(digit);

            BigInteger aNext = a.multiply(c);
            BigInteger bNext = c.pow(2).multiply(BigInteger.valueOf(digit)).subtract(c.multiply(b));
            BigInteger cNext = a.pow(2).multiply(n).subtract(b.subtract(c.multiply(BigInteger.valueOf(digit))).pow(2));
            BigInteger ac = aNext.gcd(cNext);
            BigInteger bc = bNext.gcd(cNext);
            BigInteger abc = ac.gcd(bc);
            a = aNext.divide(abc);
            b = bNext.divide(abc);
            c = cNext.divide(abc);
        }

        return result;
    }

    public long getSequenceCount(ArrayList<Integer> digits) {
        ArrayList<Integer> digitsWithoutFirst = new ArrayList<>(digits.subList(1, digits.size()));

        Integer lastElement = digitsWithoutFirst.get(digitsWithoutFirst.size()-1);
        List<Integer> indexesOfLastElement = IntStream.range(0,digitsWithoutFirst.size())
                .filter(i -> digitsWithoutFirst.get(i).equals(lastElement))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Collections.reverse(indexesOfLastElement);

        int size = digitsWithoutFirst.size();
        return indexesOfLastElement.stream()
                .filter(index -> {
                    int length = size - index - 1;
                    if(index  -length < 0 || index >= size - 1) return false;
                    List<Integer> lastList = digitsWithoutFirst.subList(index + 1, size);

                    for(int i = index + 1; i >= 0; i -= length) {
                        List<Integer> testList = digitsWithoutFirst.subList(i, i + length);
                        if(!testList.equals(lastList)) return false;
                    }
                    return true;
                })
                .map(index -> size - index - 1)
                .findFirst()
                .orElse(0);

    }
}