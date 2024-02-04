package com.gr.java9;

import java.time.LocalDate;

public class App implements HolidayCalendar{

    @Override
    public boolean isHoliday(LocalDate date) {
        return false;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.nextDay(LocalDate.now()));
        System.out.println(app.isBusinessDay(LocalDate.now()));
    }
}
