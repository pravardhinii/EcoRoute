package com.ecoroute.model;

import java.util.Optional;

public class TransportLeg {
    private String mode; // e.g., ELECTRIC_FREIGHT, DIESEL_TRUCK, CARGO_SHIP
    private double distanceKm;
    private Optional<Double> customEmissionFactor; // Defensive Coding with Optional

    public TransportLeg(String mode, double distanceKm, Double customEmissionFactor) {
        this.mode = mode;
        this.distanceKm = distanceKm;
        this.customEmissionFactor = Optional.ofNullable(customEmissionFactor);
    }

    public String getMode() { return mode; }
    public double getDistanceKm() { return distanceKm; }
    public Optional<Double> getCustomEmissionFactor() { return customEmissionFactor; }
}