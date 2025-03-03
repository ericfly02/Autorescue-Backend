package autorescue.nokia.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import autorescue.dto.DeviceStatusResponse;
import autorescue.dto.KYCMatchRequest;
import autorescue.dto.KYCMatchResponse;
import autorescue.dto.LocationRetrievalResponse;
import autorescue.nokia.NokiaClient;
import lombok.RequiredArgsConstructor;

@Service("NokiaService")
@RequiredArgsConstructor
public class NokiaClientImpl implements NokiaClient {

	@Override
	public boolean callDeviceStatus(String phone) {
		HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
				.uri(URI.create("https://device-status.p-eu.rapidapi.com/connectivity"))
				.header("x-rapidapi-key", "cf9798db7dmsh3bf062e96ec5a34p164ccbjsnffa81dfdc2c0")
				.header("x-rapidapi-host", "device-status.nokia.rapidapi.com")
				.header("Content-Type", "application/json")
				.method("POST",
						HttpRequest.BodyPublishers.ofString("{\"device\":{\"phoneNumber\": \"" + phone + "\"}}"))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			DeviceStatusResponse deviceStatusResponse = objectMapper.readValue(response.body(),
					DeviceStatusResponse.class);
			if ("CONNECTED_DATA".equals(deviceStatusResponse.getConnectivityStatus())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public LocationRetrievalResponse callLocationRetrieval(String phone) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://location-retrieval.p-eu.rapidapi.com/retrieve"))
				.header("x-rapidapi-key", "cf9798db7dmsh3bf062e96ec5a34p164ccbjsnffa81dfdc2c0")
				.header("x-rapidapi-host", "location-retrieval.nokia.rapidapi.com")
				.header("Content-Type", "application/json").method("POST", HttpRequest.BodyPublishers
						.ofString("{\"device\":{\"phoneNumber\":\"" + phone + "\"},\"maxAge\":6000}"))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			LocationRetrievalResponse deviceStatusResponse = objectMapper.readValue(response.body(),
					LocationRetrievalResponse.class);
			return deviceStatusResponse;
		} catch (Exception e) {
			throw e;

		}
	}

	@Override
	public KYCMatchResponse callKYCMatch(KYCMatchRequest request) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String requestStr = objectMapper.writeValueAsString(request);
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://kyc-match.p-eu.rapidapi.com/kyc-match/kyc-match/v0.2/match"))
				.header("x-rapidapi-key", "cf9798db7dmsh3bf062e96ec5a34p164ccbjsnffa81dfdc2c0")
				.header("x-rapidapi-host", "kyc-match.nokia.rapidapi.com").header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString(requestStr)).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
			KYCMatchResponse deviceStatusResponse = objectMapper.readValue(response.body(), KYCMatchResponse.class);
			return deviceStatusResponse;
		} catch (Exception e) {
			throw e;

		}
	}

}
