package com.gr.java9;

import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Example of Stream.iterate method
public class StreamIterate {

    public static void main(String[] args) {

        //Java 8
        iterate();

        //Java 9
        iterateWithCondition();
    }



    private static void iterate() {

        //Example one
        Stream.iterate(0, n-> n + 2)
                .limit(10)
                .forEach(System.out::println);

        LocalDate today = LocalDate.now();
        Stream.iterate(today, date -> date.plusDays(1))
                .limit(7)
                .forEach(System.out::println);
    }

    private static void iterateWithCondition() {


        System.out.println("Using takeWhile : ");
        Stream.iterate(0, n -> n + 2)
                .takeWhile( n -> n < 20)
                .forEach(System.out::println);

        System.out.println("Using iterate/predicate : ");
        Stream.iterate(0, n -> n <=100 , n -> n + 2)
                .forEach(System.out::println);

        long result =
                IntStream.iterate(1, n -> n <= 1000, n -> n+1)
                        .filter(number -> number % 7  == 0)
                        .count();
        System.out.println(result);

    }
}
