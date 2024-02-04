package com.gr.java9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Shows example of takeWhile,dropWhile.
public class TakeWhileDropWhile {
	
	public static void main(String[] args) {

		List<Stock> stocks = getStocks();
		System.out.println("Stocks sorted : \n"+stocks);

		//Using filter
		List<String> stockBelow500Filter = getStocksBelowFiveHundredFilter(stocks);
		System.out.println("Filter output: " + stockBelow500Filter);

		//takeWhile
		// if(condition) {take} else {stop - cut off from stream}
		List<String> stockBelow500 = getStocksBelowFiveHundred(stocks);
		System.out.println("takeWhile output: "+ stockBelow500);

		//condition = if(value) <= 500
		//dropWhile
		// if(condition) {drop} else {take rest of the stream}
		List<String> stockAbove500 = getStocksAboveFiveHundred(stocks);
		System.out.println("dropWhile output: "+stockAbove500);
	}

	public static List<String> getStocksBelowFiveHundredFilter(List<Stock> stocks) {
		return stocks.stream()
				.filter(TakeWhileDropWhile::isStockLessThanFiveHundred)
				.map(Stock::getName)
				.collect(Collectors.toList());
	}

	public static List<String> getStocksBelowFiveHundred(List<Stock> stocks) {
		return stocks.stream()
				.peek(stock -> System.out.println("takeWhile processing : "+stock))
				.takeWhile(TakeWhileDropWhile::isStockLessThanFiveHundred)
				.map(Stock::getName)
				.collect(Collectors.toList());
	}

	public static List<String> getStocksAboveFiveHundred(List<Stock> stocks) {
		return stocks.stream()
				.dropWhile(TakeWhileDropWhile::isStockLessThanFiveHundred)
				.map(Stock::getName)
				.collect(Collectors.toList());
	}

	private static boolean isStockLessThanFiveHundred(Stock stock) {
		return stock.getValue().compareTo(BigDecimal.valueOf(500)) <= 0 ;
	}

	private static List<Stock> getStocks() {
		List<Stock> stocks = new ArrayList<>();
		stocks.add(new Stock("Apple",BigDecimal.valueOf(1000)));
		stocks.add(new Stock("Amazon",BigDecimal.valueOf(800)));
		stocks.add(new Stock("Tesla",BigDecimal.valueOf(400)));
		stocks.add(new Stock("Netflix",BigDecimal.valueOf(2000)));
		stocks.add(new Stock("Facebook",BigDecimal.valueOf(500)));
		stocks.add(new Stock("Instagram",BigDecimal.valueOf(100)));
		
		return stocks;
	}

}
