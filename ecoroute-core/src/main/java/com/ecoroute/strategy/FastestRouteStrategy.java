package com.ecoroute.strategy;

import com.ecoroute.model.Shipment;

public class FastestRouteStrategy implements RoutingStrategy {
    @Override
    public double calculateRouteImpact(Shipment shipment) {
        return shipment.getLegs().stream()
            .mapToDouble(leg -> {
                double factor = leg.getCustomEmissionFactor().orElse(0.20); // Higher factor for fast transit
                return leg.getDistanceKm() * shipment.getCargoWeightKg() * factor;
            })
            .sum();
    }

    @Override
    public String getStrategyName() {
        return "FASTEST_ROUTE";
    }
}