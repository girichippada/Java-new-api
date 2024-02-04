package com.gr.java14;


import java.util.Date;

public class InstanceOf {

    public static void main(String[] args) {

        Object object = someThirdPartyCode();

        if (object instanceof String result && result.length() > 5) {
            System.out.println(result.toUpperCase());
        } else if (object instanceof Date result) {
            System.out.println(result.getTime());
        } else if (object instanceof Number result) {
            System.out.println(result.intValue());
        }
    }

    private static Object someThirdPartyCode() {
        return 10;
    }

}