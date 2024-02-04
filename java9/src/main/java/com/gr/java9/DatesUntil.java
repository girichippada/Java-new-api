package com.gr.java9;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

//Example of datesUntil introduced in Java 9.
//Solution to Assignment 3 b
public class DatesUntil {

    public static void main(String[] args) {

        displayNext7DaysOfWeek();
        totalLeapYearsSince1900();
    }

    public static void displayNext7DaysOfWeek() {
        LocalDate today = LocalDate.now();

        //incremental step of 1 day.
        today.datesUntil(today.plusDays(7))
                .map(LocalDate::getDayOfWeek)
                .forEach(System.out::println);
    }

    /* Solution to Assignment 3 b.
    Find total number of leap years since 1900 */
    public static void totalLeapYearsSince1900() {

        LocalDate today = LocalDate.now();
        LocalDate nineteenHundred = LocalDate.ofYearDay(1900,1);

        long totalLeapYearsSince1900 =
                nineteenHundred.datesUntil(today, Period.ofYears(1))
                               .mapToInt(LocalDate::getYear)
                               .filter(Year::isLeap)
                               .count();

        System.out.println("Total leap years since 1900 :" +totalLeapYearsSince1900);
    }

}
