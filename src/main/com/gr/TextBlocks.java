package com.gr;

public class TextBlocks {
    public static void main(String[] args) {
        System.out.println("""
                "Line1"
                    'Sub Line1 of Line1'
                Line2
                Line3
                Line4
                    Line1 of 4
                        Line1 of 4-1
                        Line2 of 4-1
                """);
    }
}
