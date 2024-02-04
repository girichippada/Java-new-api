package com.gr.java12;

import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollector {
	
	public static void main(String[] args) {
		
		List<String> input = List.of("Reading","someone","else's","code","is","tough");
		
		Statistics data = input.stream()
		                       .collect(Collectors.teeing(
		    		                    		          Collectors.joining(" "), 
		    		                    		          Collectors.counting(),
		    		                    		          Statistics::new
		    		                                     )
		                    		   );
		System.out.println(data);
	}

}

class Statistics{
	
	final private String data;
	final private long noOfWords;
	
	public Statistics(String data,long noOfWords) {
		this.data = data;
		this.noOfWords = noOfWords;
	}
	
	@Override
	public String toString() {
		return "Data : " + data + ", has a word count of: " + noOfWords;
	}
}

