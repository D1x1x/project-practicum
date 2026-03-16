package ru.tbank.practicum.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tbank.practicum.Other.CurtainsStatus;
import ru.tbank.practicum.service.MenuService;

import java.awt.*;

@Controller
public class MenuController {



    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("temperature", menuService.getCurrentRadiatorTemperature());
        model.addAttribute("curtains", menuService.getCurtainsStatus());
        model.addAttribute("curtainsStatuses", CurtainsStatus.values());
        return "index";
    }


    @PostMapping("/temperature")
    public String post(@RequestParam @Min(10) @Max(40) int temperature) {
        menuService.setCurrentRadiatorTemperature(temperature);
        return "redirect:/";
    }

    @PostMapping("/curtains")
    public String post(@RequestParam CurtainsStatus curtainStatus) {
        menuService.setCurtainsStatus(curtainStatus);
        return "redirect:/";
    }


}
