package com.gr.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranslateEscapes {

    public static void main(String[] args) throws IOException {

        String withEscapes = "\"Java\t13\"";
        System.out.println(withEscapes);

        Map<Integer, List<String>> data;

        try(Stream<String> text = Files.lines(Path.of("src/java13/escapes.txt"))){
            data = text.filter(Predicate.not(String::isEmpty))
                       .map(String::translateEscapes)
                       .collect(Collectors.groupingBy(String::length));

        }
        System.out.println(data);
    }
}
