package com.gr.java9;

public class IndifyStringConcatenation {

    public static void main(String[] args) {
        logger("Changes in JDK 9",23);
    }

    private static void logger(String message, int count) {
        System.out.println("[" + System.currentTimeMillis() + "]"
        + " : " + message + " (" + count+ ")");
    }
}
