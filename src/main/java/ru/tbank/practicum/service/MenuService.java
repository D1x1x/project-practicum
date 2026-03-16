package ru.tbank.practicum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.tbank.practicum.Other.CurtainsStatus;

@Service
public class MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    private int currentRadiatorTemperature = 25;
    private CurtainsStatus curtainsStatus = CurtainsStatus.OPEN;

    public int getCurrentRadiatorTemperature() {
        return currentRadiatorTemperature;
    }

    public CurtainsStatus getCurtainsStatus() {
        return curtainsStatus;
    }
    public void setCurrentRadiatorTemperature(int newRadiatorTemperature) {
        int temp = currentRadiatorTemperature;
        this.currentRadiatorTemperature = newRadiatorTemperature;
        logger.info("Температура изменилась с {} на {}", temp, newRadiatorTemperature);
    }
    public void setCurtainsStatus(CurtainsStatus newStatus) {
        CurtainsStatus temp = curtainsStatus;
        this.curtainsStatus = newStatus;
        logger.info("Статус изменился с {} на {}",temp,curtainsStatus);
    }

}
