package com.gr;

import static java.util.Calendar.*;

public class SwitchExpression {

    public static String findDayOfWeek(int day){

        return switch (day){
            case SUNDAY -> "SUNDAY";
            case MONDAY -> "MONDAY";
            case TUESDAY -> "TUESDAY";
            case WEDNESDAY -> "WEDNESDAY";
            case THURSDAY -> {
                System.out.println("Complex logic goes here..");
                yield "THURSDAY";
            }
            case FRIDAY -> "FRIDAY";
            case SATURDAY -> "SATURDAY";

            default ->  throw new IllegalArgumentException("Invalid Option %s".formatted(day));
        };
    }
    public static void main(String[] args) {
        int[] dayCodes = new int[]{1, 2, 7, 6, 3, 6, 7, 5, 9, 0};
        for(var dayCode: dayCodes)
            System.out.println(findDayOfWeek(dayCode));
    }
}
