package com.ecoroute.calculator;

import com.ecoroute.model.Shipment;
import com.ecoroute.strategy.RoutingStrategy;

public class EmissionCalculator {
    private final RoutingStrategy strategy;

    public EmissionCalculator(RoutingStrategy strategy) {
        this.strategy = strategy;
    }

    public double computeTotalEmissions(Shipment shipment) {
        if (shipment == null || shipment.getLegs() == null) {
            throw new IllegalArgumentException("Shipment data cannot be null.");
        }
        return strategy.calculateRouteImpact(shipment);
    }
}