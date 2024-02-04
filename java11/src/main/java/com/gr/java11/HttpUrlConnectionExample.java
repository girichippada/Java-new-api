package com.gr.java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionExample {

	public static void main(String[] args) throws IOException {

		final var uri = "https://www.boredapi.com/api/activity";
		
		var url = new URL(uri);
		var httpURLConnection = (HttpURLConnection) url.openConnection();

		httpURLConnection.setRequestMethod("GET");
	
		if(httpURLConnection.getResponseCode() == 200) {
			System.out.println(readResponse(httpURLConnection.getInputStream()));
		}else {
			System.out.println("Something went wrong...");
		}
	}

	private static String readResponse(InputStream inputStream) throws IOException {
		var content = new StringBuilder();
		try(var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
			var response = "";
			while((response = bufferedReader.readLine()) != null) {
				content.append(response);
			}
		}
		return content.toString();
	}
}
