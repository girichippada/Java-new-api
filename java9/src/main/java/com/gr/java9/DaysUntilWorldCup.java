package com.gr.java9;

import java.time.LocalDate;

//Solution to Assignment 3 a
//how many days until the 2022 world cup ?
public class DaysUntilWorldCup {

    public static void main(String[] args) {

        LocalDate threeMonthsFromNow = LocalDate.now().plusMonths(3);
        //Football world cup starts on 21st November 2022.
        LocalDate worldCupStartDate = LocalDate.of(threeMonthsFromNow.getYear()
                , threeMonthsFromNow.getMonth().plus(3)
                , threeMonthsFromNow.getDayOfMonth());

        LocalDate now = LocalDate.now();

        //datesUntil returns a Stream<LocalDate>
        //Incremental step of 1 day.

        long noOfDaysUntilWorldCup = now.datesUntil(worldCupStartDate)
                .count();

        System.out.println("Football world cup starts in " + noOfDaysUntilWorldCup + " days");
    }
}
