package ru.tbank.practicum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.tbank.practicum.dto.WeatherProperties;
import ru.tbank.practicum.dto.WeatherResponse;

@Service
public class WeatherApiClient {

    private static final Logger logger = LoggerFactory.getLogger(WeatherApiClient.class);

    private final RestClient restClient;
    private final WeatherProperties weatherProperties;

    public WeatherApiClient(RestClient restClient, WeatherProperties weatherProperties) {
        this.restClient = restClient;
        this.weatherProperties = weatherProperties;
    }

    public WeatherResponse getWeather() {

        WeatherResponse weatherResponse = restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/2.5/weather")
                        .queryParam("lat", 51.32)
                        .queryParam("lon", 46)
                        .queryParam("appid", weatherProperties.apiKey())
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .body(WeatherResponse.class);
        return weatherResponse;
    }
}
