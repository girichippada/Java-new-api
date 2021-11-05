package com.gr;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNotRunner {

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> inputNumbersList = List.of(1,5,7,3,4,8,10);

        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;

        inputNumbersList.stream().filter(isEvenPredicate.negate()).forEach(System.out::println);

        System.out.println("Using Predicate:");
        inputNumbersList.stream().filter(Predicate.not(PredicateNotRunner::isEven)).forEach(System.out::println);


    }

}
