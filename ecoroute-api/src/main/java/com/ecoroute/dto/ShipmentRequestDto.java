package com.ecoroute.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ShipmentRequestDto {
    @NotBlank(message = "Tracking ID is mandatory")
    private String trackingId;

    @Positive(message = "Cargo weight must be greater than zero")
    private double cargoWeightKg;

    @Positive(message = "Distance must be greater than zero")
    private double distanceKm;

    public String getTrackingId() { return trackingId; }
    public double getCargoWeightKg() { return cargoWeightKg; }
    public double getDistanceKm() { return distanceKm; }
}