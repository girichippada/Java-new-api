package com.gr.java10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class VarValidUsage {

    public static void displayNames() {

        var clubList = List.of("Real Madrid", "Atletico Madrid", "Barcelona");

        for (var clubName : clubList) {
            System.out.println(clubName);
        }
    }

    public static void readFile() {

        try (var scanner = new Scanner(VarValidUsage.class.getClassLoader().getResource("test.txt").getFile())) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }


    public static void main(String[] args) {

        displayNames();
        readFile();

    }
}
