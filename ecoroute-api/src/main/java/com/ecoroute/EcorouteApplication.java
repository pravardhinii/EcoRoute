package com.ecoroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EcorouteApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcorouteApplication.class, args);
    }
}