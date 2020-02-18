package com.project.problems;

import com.project.util.ProblemBase;

public class p19 extends ProblemBase {

    public Long execute() {
        Integer weekday = 2; //tuesday
        Integer count = 0;

        for(int year = 1901; year < 2001; year++) {
            for(int month = 1; month < 13; month++) {
                weekday = addMonth(weekday, month, year);
                if(weekday == 0) {
                    count++;
                }
            }
        }

        return Long.valueOf(count);
    }

    public static Integer addMonth(Integer weekday, Integer month, Integer year) {
        Integer monthDays;
        switch (month) {
            case 9:
            case 4:
            case 6:
            case 11:
                monthDays = 30;
                break;
            case 2:
                if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    monthDays = 29;
                } else {
                    monthDays = 28;
                }
                break;
            default:
                monthDays = 31;
        }
        return (weekday + monthDays) % 7;
    }
}
