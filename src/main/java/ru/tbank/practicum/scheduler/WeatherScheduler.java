package ru.tbank.practicum.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.practicum.dto.WeatherProperties;
import ru.tbank.practicum.dto.WeatherResponse;
import ru.tbank.practicum.service.WeatherApiClient;

@Component
public class WeatherScheduler {

    private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);

    private final WeatherApiClient weatherApiClient;

    private final WeatherProperties weatherProperties;

    public WeatherScheduler(WeatherApiClient weatherApiClient, WeatherProperties weatherProperties) {
        this.weatherApiClient = weatherApiClient;
        this.weatherProperties = weatherProperties;
    }

    @Scheduled(fixedRate = 6000)
    public void queryWeather() {
        logger.info("Начали запрос к погоде в городе {}", weatherProperties.city());
        try {

            WeatherResponse weather = weatherApiClient.getWeather();
            double temp = weather.main().temp();
            String country = weather.sys().country();
            logger.info(
                    "В стране {}, в городе {}, погода на данный момент {}", country, weatherProperties.city(), temp);

        } catch (Exception e) {
            logger.info("Ошибка {}", e.getMessage());
        }
    }
}
