package com.ecoroute.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shipments")
public class ShipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingId;
    private double cargoWeightKg;
    private double totalEmissions;

    public ShipmentEntity() {}

    public ShipmentEntity(String trackingId, double cargoWeightKg, double totalEmissions) {
        this.trackingId = trackingId;
        this.cargoWeightKg = cargoWeightKg;
        this.totalEmissions = totalEmissions;
    }

    public Long getId() { return id; }
    public String getTrackingId() { return trackingId; }
    public double getCargoWeightKg() { return cargoWeightKg; }
    public double getTotalEmissions() { return totalEmissions; }
}