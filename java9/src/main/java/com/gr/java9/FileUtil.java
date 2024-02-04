package com.gr.java9;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        Files.lines(Paths.get(FileUtil.class.getClassLoader().getResource("data.txt").toURI()))
        .forEach(System.out::println);
    }
}
