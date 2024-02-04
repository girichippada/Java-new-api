package com.gr.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCompare {
	
	public static void main(String[] args) throws IOException {
		
		Path fileOnePath = Path.of("src/java12/readme.txt");
		Path fileTwoPath = Path.of("src/java12/readmealso.txt");
		
		long mismatchIndex = Files.mismatch(fileOnePath,fileTwoPath);
		
		System.out.println(mismatchIndex);	
	}

}
