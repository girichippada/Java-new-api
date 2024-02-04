package com.gr.java16;

//Example of pattern matching for instanceof
public class PatternMatching {

    public static void main(String[] args) {

        Object value = getValue();

        String result = "unknown";

        if (value instanceof String s){
           result = String.format("String %s",s);
        }
        else if (value instanceof Byte b){
            result = String.format("Byte %d",b);
        }
        else if (value instanceof Short s){
            result = String.format("Short %d",s);
        }
        else if (value instanceof Double d) {
            result = String.format("Double %f", d);
        }
        else if (value instanceof Integer i) {
            result = String.format("Integer %d", i);
        }
        else if (value instanceof Long l){
            result = String.format("Long %d", l);
        }

        System.out.println(result);
    }

    private static Object getValue() {
        return  Short.valueOf("123");
    }
}