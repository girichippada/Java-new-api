package com.gr.java9;

import java.util.List;
import java.util.stream.Collectors;

//Example of limit and skip.
public class LimitSkip {

    public static void main(String[] args) {
        limit();
        skip();
    }

    public static void limit(){
        List<String> data =
                getData().stream()
                        .limit(5)
                        .collect(Collectors.toList());
        System.out.println(data);
    }

    public static List<String> getData(){
        return List.of("a","c", "e","g","i","j","l","n");
    }

    public static void skip() {
        List<String> data =
                getData().stream()
                        .skip(5)
                        .collect(Collectors.toList());
        System.out.println(data);
    }
}
