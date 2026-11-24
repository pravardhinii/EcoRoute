package com.ecoroute.strategy;

import com.ecoroute.model.Shipment;
import com.ecoroute.model.TransportLeg;

public class GreenestRouteStrategy implements RoutingStrategy {
    @Override
    public double calculateRouteImpact(Shipment shipment) {
        return shipment.getLegs().stream()
            .mapToDouble(leg -> {
                double factor = leg.getCustomEmissionFactor().orElse(0.05); // Lower factor for green routes
                return leg.getDistanceKm() * shipment.getCargoWeightKg() * factor;
            })
            .sum();
    }

    @Override
    public String getStrategyName() {
        return "GREENEST_ROUTE";
    }
}