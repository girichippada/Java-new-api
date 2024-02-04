package com.gr.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientSync {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
	    final String uri = "https://www.boredapi.com/api/activity";
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				 						 .uri(URI.create(uri))
				                         .GET()
				                         .build();

		HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
		if(response.statusCode() == 200) {
			System.out.println(response.body());	
		}else {
			System.out.println("Something went wrong...");
		}		
	}
}
