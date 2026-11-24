package com.ecoroute.model;

import java.util.List;

public class Shipment {
    private String trackingId;
    private double cargoWeightKg;
    private List<TransportLeg> legs;

    public Shipment(String trackingId, double cargoWeightKg, List<TransportLeg> legs) {
        this.trackingId = trackingId;
        this.cargoWeightKg = cargoWeightKg;
        this.legs = legs;
    }

    public String getTrackingId() { return trackingId; }
    public double getCargoWeightKg() { return cargoWeightKg; }
    public List<TransportLeg> getLegs() { return legs; }
}