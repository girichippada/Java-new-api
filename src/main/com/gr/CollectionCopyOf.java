package com.gr;

import java.util.ArrayList;
import java.util.List;

public class CollectionCopyOf {

    public static void main(String[] args) {
        List<String> myTopics = new ArrayList<>();
        myTopics.add("Java");
        myTopics.add("Spring Boot");
        myTopics.add("Hibernate");

        List<String> copyOfMyTopics = List.copyOf(myTopics);
        addNewTopics(myTopics);

        System.out.println("myTopics are:");
        myTopics.forEach(System.out::println);

        System.out.println("\nmyTopics with copy are:");
        copyOfMyTopics.forEach(System.out::println);

    }

    private static void addNewTopics(List<String> myTopics) {
        myTopics.add("Microservices");
    }
}
