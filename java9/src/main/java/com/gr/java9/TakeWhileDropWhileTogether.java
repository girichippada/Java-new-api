package com.gr.java9;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Solution to Assignment 1.
public class TakeWhileDropWhileTogether {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Predicate<String> containsNoHash = line -> !line.contains("#");

        List<String> result;
        try(Stream<String> lines = Files.lines(Paths.get(
                TakeWhileDropWhileTogether.class.getClassLoader().getResource("data.txt").toURI()))){
            result = lines.dropWhile(containsNoHash)
                          .skip(1)
                          .takeWhile(containsNoHash)
                          .collect(Collectors.toList());
        }

        System.out.println(result);
    }
}
