package com.gr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesReadAndWrite {
    public static void main(String[] args) throws IOException {
        Path sampleFilePath = Paths.get("./resources/Sample.txt");
        String sampleFileContent = Files.readString(sampleFilePath);

        System.out.println("Content is: " + sampleFileContent);

        Path newSampleFilePath = Paths.get("./resources/Sample-new.txt");
        Files.writeString(newSampleFilePath, sampleFileContent.replaceAll("Line", "Line Number "));

        System.out.println("New Content is: " + newSampleFilePath);

    }
}
