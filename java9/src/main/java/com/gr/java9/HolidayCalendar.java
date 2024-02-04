package com.gr.java9;

import java.time.LocalDate;

//Example of private methods in an interface.
public interface HolidayCalendar {

    boolean isHoliday(LocalDate date);

    default boolean isBusinessDay(LocalDate date){
        validate(date);
        return !isHoliday(date);
    }

    default LocalDate nextDay(LocalDate date){
        validate(date);
        LocalDate nextDate = date.plusDays(1);
        return isHoliday(nextDate) ? nextDay(nextDate) : nextDate;
    }

    private void validate(LocalDate date){
        if (date.isBefore(LocalDate.of(2001, 1, 1))) {
            throw new IllegalArgumentException();
        }
    }


}
