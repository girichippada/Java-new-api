package com.gr;

import java.util.List;

public class TypeInference {

    public static void main(String[] args) {
        List<String> list1 = List.of("private", "gov");
        List<String> list2 = List.of("urban", "rural");

        var completeList = List.of(list1, list2);
        for(var member: completeList){
            System.out.println(member);
        }
    }
}
