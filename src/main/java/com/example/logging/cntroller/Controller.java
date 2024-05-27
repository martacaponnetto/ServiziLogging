package com.example.logging.cntroller;

import com.example.logging.service.ExpoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ExpoService expoService;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public String welcomeMessage() {
        logger.info("Welcome message requested.");
        return "Welcome to the Spring Boot application!";
    }

    @GetMapping("/exp")
    public int getExponent() {
       return expoService.calculateExponent();
    }

    @GetMapping("/get-errors")
    public String getError() {
        String message = "error!";
        Error error = new Error("attention! Error");
        logger.error("Custom error occurred!");
        return message;
    }
}
