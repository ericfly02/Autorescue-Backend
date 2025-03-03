package autorescue.nokia.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import autorescue.nokia.NokiaClient;
import lombok.RequiredArgsConstructor;

@Service("NokiaService")
@RequiredArgsConstructor
public class NokiaClientImpl implements NokiaClient {
	
	@Override
	public boolean callDeviceStatus() {
		HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
				.uri(URI.create("https://device-status.p-eu.rapidapi.com/connectivity"))
				.header("x-rapidapi-key", "cf9798db7dmsh3bf062e96ec5a34p164ccbjsnffa81dfdc2c0")
				.header("x-rapidapi-host", "device-status.nokia.rapidapi.com")
				.header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\"device\":{\"phoneNumber\": \"+36721601234567\"}}"))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
