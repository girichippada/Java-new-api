package com.gr.java14;


import java.time.DayOfWeek;
import java.time.chrono.IsoChronology;
import java.util.concurrent.ThreadLocalRandom;

//Assignment
public class Switches {

    public static void main(String[] args) {

        //1st assignment
        int year = 2000;
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        System.out.println("The input month is : "+ month);

        int monthLength = lengthOfMonthExpression(year,month);
        System.out.println("\nThe number of days in the month is : "+monthLength);

        //2nd assignment.
        int dayOfWeekInt = ThreadLocalRandom.current().nextInt(1, 8);
        DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekInt);

        System.out.println("\nThe day of the week is: "+ dayOfWeek);
        Activity activity  = getActivity(dayOfWeek);
        System.out.println("Activity today : " + activity);

    }

    public static int lengthOfMonthRefactored(int year, int month) {
        return switch (month){
            case 2 ->   IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28;
            case 4,6,9,11 -> 30;
            default -> 31;
        };
    }

    public static int lengthOfMonth(int year, int month) {
        switch (month) {
            case 2:
                return IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static int lengthOfMonthExpression(int year, int month) {
        return switch (month) {
            case 2 -> IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    public static Activity getActivity(DayOfWeek dayOfWeek) {
        Activity activity = Activity.FOOTBALL;
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case FRIDAY:
                activity = Activity.WORK;
                System.out.println("All work and no play makes Jack a dull boy...");
                break;
            case WEDNESDAY:
                activity = Activity.SLEEP;
                System.out.println("Recovering from work...");
            case THURSDAY:
                activity = Activity.MUSIC;
                System.out.println("Still recovering from work...");
                break;
            case SATURDAY:
            case SUNDAY:
                activity = Activity.FOOTBALL;
                System.out.println("Football is like life...");
                break;
        }
        return activity;
    }

    public static Activity getActivityExpression(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, FRIDAY -> {
                System.out.println("All work and no play makes Jack a dull boy...");
                yield Activity.WORK;
            }
            case WEDNESDAY -> {
                System.out.println("Recovering from work...");
                yield Activity.SLEEP;
            }
            case THURSDAY -> {
                System.out.println("Still recovering from work...");
                yield Activity.MUSIC;
            }
            case SATURDAY, SUNDAY -> {
                System.out.println("Football is like life...");
                yield Activity.FOOTBALL;
            }
        };
    }
}
