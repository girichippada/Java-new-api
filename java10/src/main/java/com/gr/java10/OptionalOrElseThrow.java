package com.gr.java10;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

//Example of orElseThrow method in Optional class.
public class OptionalOrElseThrow {

	public static void main(String[] args) {

		OptionalOrElseThrow optionalOrElse = new OptionalOrElseThrow();
		String largeWord = optionalOrElse.findLargeWord();
		System.out.println("Large word is : "+largeWord);

	}

	public String findLargeWord() {

		Optional<String> largeWord = searchLargeWord();
		//Avoid
		if(largeWord.isPresent()){
			return largeWord.get();
		}
		throw new NoSuchElementException("Word not found...");
	}

	private Optional<String> searchLargeWord() {

		return Stream.of("football", "12345678", "hellojava")
				     .filter(s -> s.length() >= 20)
				     .findAny();
	}

}
