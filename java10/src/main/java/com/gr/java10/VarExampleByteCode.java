package com.gr.java10;

public class VarExampleByteCode {

	public static void main(String[] args) {
		int sum = 0;
		sum += 1;

		var sumV = 0;
		sumV += 1;

		System.out.println(sum);
		System.out.println(sumV);
	}

}
