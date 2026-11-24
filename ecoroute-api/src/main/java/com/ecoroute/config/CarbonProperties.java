package com.ecoroute.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.carbon")
public class CarbonProperties {
    private double maxAllowedEmissions;
    private String defaultStandard;

    public double getMaxAllowedEmissions() { return maxAllowedEmissions; }
    public void setMaxAllowedEmissions(double maxAllowedEmissions) { this.maxAllowedEmissions = maxAllowedEmissions; }
    public String getDefaultStandard() { return defaultStandard; }
    public void setDefaultStandard(String defaultStandard) { this.defaultStandard = defaultStandard; }
}