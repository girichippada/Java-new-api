package com.gr.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

//Example shows async + retrieve headers
public class HeaderAsyncHttpClient {
	
	public static void main(String[] args) {
		HttpClient httpClient = HttpClient.newBuilder()
				                          .version(Version.HTTP_2)
				                          .build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
											 .GET()
											 .build();
		
		
		CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(httpRequest, BodyHandlers.ofString());
		
		response.thenAccept( res -> System.out.println(res.headers().map()));
		response.join();		
	}

}
