package com.ecoroute.config;

import com.ecoroute.strategy.GreenestRouteStrategy;
import com.ecoroute.strategy.RoutingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton") // Shared stateless strategy bean
    public RoutingStrategy greenestRouteStrategy() {
        return new GreenestRouteStrategy();
    }
}