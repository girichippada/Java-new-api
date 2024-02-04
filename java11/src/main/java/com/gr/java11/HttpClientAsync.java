package com.gr.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientAsync {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
	    final String uri = "https://www.boredapi.com/api/activity";
		
		HttpClient httpClient = HttpClient.newBuilder()
				                          .connectTimeout(Duration.ofSeconds(3))
				                          .build();
		
		HttpRequest request = HttpRequest.newBuilder()
				 						 .uri(URI.create(uri))
				                         .GET()
				                         .build();
	
		CompletableFuture<HttpResponse<String>> resultFuture = 
				httpClient.sendAsync(request, BodyHandlers.ofString());
				
		resultFuture.thenApply(HttpResponse::body)
					.exceptionally(ex -> "Something went wrong...")
	      	  		.thenAccept(System.out::println);
		
		resultFuture.join();
	}
}
