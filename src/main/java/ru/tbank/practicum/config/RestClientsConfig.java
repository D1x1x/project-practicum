package ru.tbank.practicum.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.tbank.practicum.dto.WeatherProperties;

@EnableConfigurationProperties(WeatherProperties.class)
@Configuration
public class RestClientsConfig {
    @Bean
    RestClient weatherRestClient(WeatherProperties weatherProperties) {
        return RestClient.builder().baseUrl(weatherProperties.baseUrl()).build();
    }
}
