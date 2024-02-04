package com.gr.java11;

public class EpsilonGCTest {

    public static void main(String[] args) {

        final int MEGABYTE_IN_BYTES = 1024 * 1024 ;
        final int ITERATIONS = 1024;

        System.out.println("Starting allocations...");

        for (int i = 0; i < ITERATIONS; i++) {
            var array = new byte[MEGABYTE_IN_BYTES];
        }

        System.out.println("Completed successfully");
    }
}
