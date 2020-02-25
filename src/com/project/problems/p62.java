package com.project.problems;

import com.project.base.ProblemBase;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class p62 extends ProblemBase {

    public Long execute() {
        HashMap<BigInteger, HashMap<Character, Integer>> cubeMaps = new HashMap<>();
        ArrayList<BigInteger> results = new ArrayList<>();
        int length = 0;
        for(int i = 0;  ; i++) {
            BigInteger number = BigInteger.valueOf(i);
            number = number.pow(3);
            if(String.valueOf(number).length() > length && !results.isEmpty()) {
                break;
            }
            HashMap<Character, Integer> map = convertToMap(number);


            ArrayList<BigInteger> permutations = cubeMaps.keySet().stream()
                    .filter(cube -> cubeMaps.get(cube).equals(map))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            if(permutations.size() > 4 && results.contains(permutations.get(0))) {
                permutations.add(number);
                System.out.println("Invalid: " + permutations);
                results.remove(permutations.get(0));
            }

            if(permutations.size() == 4) {
                permutations.add(number);
                System.out.println(permutations);
                permutations.sort(BigInteger::compareTo);
                results.add(permutations.get(0));
                length = number.toString().length();
            }



            cubeMaps.put(number, map);

        }

        results.sort(BigInteger::compareTo);
        return results.get(0).longValue();
    }

    public HashMap<Character, Integer> convertToMap(BigInteger number) {
        HashMap<Character, Integer> result = new HashMap<>();

        String numberString = number.toString();
        for(Character character : numberString.toCharArray()) {
            result.put(character, result.getOrDefault(character, 0) + 1);
        }

        return result;
    }
}
