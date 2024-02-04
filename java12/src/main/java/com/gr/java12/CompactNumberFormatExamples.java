package com.gr.java12;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExamples {
	
	public static void main(String[] args) {
		
		shortStyle();
		longStyle();
		rounding();
		fraction();
	}

	private static void longStyle() {
		NumberFormat fmt = NumberFormat.getCompactNumberInstance(
				Locale.US, NumberFormat.Style.LONG);	
		
		System.out.println(fmt.format(1000));        // 1 thousand
		System.out.println(fmt.format(100_000_000)); // 100 million
		System.out.println(fmt.format(1000000000));  // 1 billion
		
	}

	private static void shortStyle() {
		NumberFormat fmt = NumberFormat.getCompactNumberInstance(
				Locale.US, NumberFormat.Style.SHORT);	
		
		System.out.println(fmt.format(1000));        // 1K
		System.out.println(fmt.format(100_000_000)); // 100M
		System.out.println(fmt.format(1000000000));  // 1B		
	}
	
	private static void rounding() {
		
		NumberFormat fmt = NumberFormat.getCompactNumberInstance(
				Locale.US, NumberFormat.Style.SHORT);	
		
		System.out.println(fmt.format(1500));        // 2K
		System.out.println(fmt.format(130_501_000)); // 131M
		
		fmt.setRoundingMode(RoundingMode.DOWN);
		
		System.out.println(fmt.format(1500));        // 1K
		System.out.println(fmt.format(130_501_000)); // 130M
	}
	
	private static void fraction() {
		
		NumberFormat fmt = NumberFormat.getCompactNumberInstance(
				Locale.US, NumberFormat.Style.SHORT);	
		
		System.out.println(fmt.format(1500));        // 2K
		System.out.println(fmt.format(130_501_000)); // 131M
		
		fmt.setMaximumFractionDigits(2);
		
		System.out.println(fmt.format(1500));        // 1.5K
		System.out.println(fmt.format(130_501_000)); // 130.5M
	}

}
