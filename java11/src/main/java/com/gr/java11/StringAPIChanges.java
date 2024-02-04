package com.gr.java11;

//Changes in String API in JDK 11.
public class StringAPIChanges {

	public static void main(String[] args) {

		// String.repeat method
		System.out.println("repeat()");
		repeat();

		// isBlank();
		System.out.println("\nisBlank()");
		isBlank();

		// strip
		System.out.println("\nstrip()");
		strip();
		
		//strip vs trim
		System.out.println("\nstrip() vs trim()");
		stripVsTrim();

		// lines
		lines();
	}

	public static void repeat() {

		var hash = "#";
		System.out.println("Hash : "+ hash.repeat(5)); // #####
		
		System.out.println("Hash : "+hash.repeat(0)); // Empty string

		// Directly on literal
		var dnaSequence = "TTAGGG".repeat(5);
		System.out.println("DNA : "+dnaSequence);
	}
    
	public static void isBlank() {

		var text = "    ";
		System.out.println("isEmpty : " + text.isEmpty());//Checks for length

		// Does the text contain a string ? - not so clear.
		System.out.println("Trim :" + "".equals(text.trim()));

		// Does the text contain a string ? clear
		System.out.println("isBlank :"+text.isBlank());
	}
	
	public static void strip() {

		var text = "     hello     \u2001";
		System.out.println(text.strip());// "hello"
		System.out.println(text.strip().length());// 5
		
		System.out.println(text.stripTrailing().length());// 10
		System.out.println(text.stripLeading().length());// 11

		System.out.println(Character.isWhitespace('\u2001')); //true
	}
	
	

	public static void stripVsTrim() {

		var text = "     hello     \u2001";
		System.out.println(text.trim().length()); // 11
		System.out.println(text.strip().length());// 5
		
		System.out.println(text.stripTrailing().length());// 10
		System.out.println(text.stripLeading().length());// 11

		System.out.println(Character.isWhitespace('\u2001'));
	}

	public static void lines() {

		System.out.println("\nlines() demo");

		var multipleLines = "\nHappy"
							 + "\nto \nlearn "
							 + "\nJava " 
							 + "\ntoday " 
							 + "\nand \r\ntomorrow.";

		String [] linesUsingSeparator  =  multipleLines.split(System.lineSeparator());
		for(String line : linesUsingSeparator){
			System.out.println(line);
		}

		//Introduced(\R) in JDK 8
		String [] linesUsingR  =  multipleLines.split("\\R");
		for(String line : linesUsingR){
			System.out.println(line);
		}

		//lines in JDK 11.
		multipleLines.lines().forEach(System.out::println);
	}

}
