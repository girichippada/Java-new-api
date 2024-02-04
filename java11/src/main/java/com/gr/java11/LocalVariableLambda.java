package com.gr.java11;

import lombok.NonNull;

import java.util.function.Function;


public class LocalVariableLambda {

	public static void main(String[] args) {

		Function<String,String> one = (String s1) -> s1.substring(0, s1.length()-1);

		Function<String,String> two = (s1) -> s1.substring(0, s1.length()-1);

		Function<String,String> three = s1 -> s1.substring(0, s1.length()-1);

		Function<String,String> four = (var s1) -> s1.substring(0, s1.length()-1);

		//Using jsr 305, see import.
		Function<String,String> five = (@NonNull var s1) -> s1.substring(0, s1.length()-1);
	}

}
