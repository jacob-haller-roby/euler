package com.project.problems;

import com.project.base.ProblemBase;

import java.util.HashMap;
import java.util.stream.LongStream;

public class p14 extends ProblemBase {

    public static HashMap<Long, Long> map = new HashMap<>();

    public Long execute() {
        map.put(1l,1l);
        LongStream.range(1,1000000).forEach(n -> {
            Long count = 0l;
            Long test = n;
            while(map.get(test) == null) {
                count++;
                if(test%2 == 0) {
                    test /= 2;
                } else {
                    test *=3;
                    test += 1;
                }
            }

            Long reverseTest = n;
            while(map.get(reverseTest) == null) {
                map.put(reverseTest, count + map.get(test));
                if(test%2 == 0) {
                    test /= 2;
                } else {
                    test *=3;
                    test += 1;
                }
                count--;
            }
        });

        Long highestValue = 0l;
        Long highestStart = 0l;
        for(Long i = 1l; i<1000000; i++) {
            if(map.get(i) > highestValue) {
                highestStart = i;
                highestValue = map.get(i);
            }
        }

        return highestStart;
    }
}
