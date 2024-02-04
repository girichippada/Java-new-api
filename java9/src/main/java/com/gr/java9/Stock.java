package com.gr.java9;

import java.math.BigDecimal;

public class Stock {

	private final String name;
	private final BigDecimal value;

	public Stock(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String toString(){
		return "Stock :" + name + " has a value of " + value+"\n";
	}
	
	
}
