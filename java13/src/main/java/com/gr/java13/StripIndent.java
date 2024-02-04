package com.gr.java13;

//Example of String.indent() introduced in JDK 13.

public class StripIndent {

    public static void main(String[] args) {
        String customerJson = ""
                +"      {\n"
                +"        \"id\" : \"1234\",\n"
                +"        \"firstName\":\"Jack\",\n"
                +"        \"lastName\":\"Sparrow\"\n"
                +"      }";

        System.out.println(customerJson.stripIndent());
    }
}
