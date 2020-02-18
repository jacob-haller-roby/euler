package com.project.problems;

import com.project.util.CharArray;
import com.project.util.Primes;
import com.project.util.ProblemBase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class p26 extends ProblemBase {

    public Long execute() {

        Pattern pattern = Pattern.compile("(.+)(?:\\1)+$");

        HashMap<Integer, Integer> map = new HashMap<>();
        Primes primes = new Primes();
        while(primes.largestPrime() < 1000) {
            primes.getNextPrime();
        }
        primes.pop();

        primes.forEach(i -> {
            BigDecimal d = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(i), (int) (i *3), RoundingMode.FLOOR);
            String digits = d.toString();
            Matcher matcher = pattern.matcher(digits);
            String repeating = null;
            while(matcher.find()) {
                repeating = matcher.group(1);
                matcher = pattern.matcher(repeating);
            }
            if(repeating != null) {
                map.put(repeating.length(), Math.toIntExact(i));
            }
        });

        int maxLength = map.keySet().stream().max(Integer::compareTo).orElse(0);
        int maxValue = map.get(maxLength);

        return (long) maxValue;
    }
}
