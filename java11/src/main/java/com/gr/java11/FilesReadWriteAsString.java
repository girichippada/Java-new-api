package com.gr.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesReadWriteAsString {
	
	public static void main(String[] args) throws IOException {
		
		readString();
		writeString();
	}
	
	private static void readString() throws IOException {

		String content = new String(Files.readAllBytes(Paths.get("src/java11/file1.txt")));
		System.out.println(content);

		//new method added in JDK11.
		String contents = Files.readString(Paths.get("src/java11/file1.txt"));
		System.out.println(contents);
	}

	private static void writeString() throws IOException {
		  
		  Files.writeString(Paths.get("src/java11/file2.txt"),"I am learning Java 11");
		  
		  var testContents = Files.readString(Paths.get("src/java11/file2.txt"));
		  System.out.println(testContents.equals("I am learning Java 11"));
	}
}
