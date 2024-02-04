package com.gr.java10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Example shows how to use copyOf method in a List.
public class CopyOfList {
	public static void main(String[] args) {

		List<String> countries = new ArrayList<>();
		countries.add("India");
		countries.add("Sweden");
		countries.add("UK");

		usingCopyOf(countries);
		usingUnmodifiableView(countries);
	}

	public static void usingUnmodifiableView(List<String> countries) {

		List<String> countryView = Collections.unmodifiableList(countries);
		//Results in UnsupportedOperationException
		// countryView.add("Denmark");

		countries.add("USA");

		System.out.println("Original - " + countries);
		System.out.println("UnmodifiableList - " + countryView);
	}

	public static void usingCopyOf(List<String> countries) {

		List<String> countryCopy = List.copyOf(countries);

		// countryCopy.add("Denmark");//Results in UnsupportedOperationException

		countries.add("USA");
		
		System.out.println("Original - " + countries);
		System.out.println("CopyOf - " + countryCopy);
	}
}

