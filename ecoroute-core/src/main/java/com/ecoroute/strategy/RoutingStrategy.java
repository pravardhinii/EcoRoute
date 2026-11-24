package com.ecoroute.strategy;

import com.ecoroute.model.Shipment;

public interface RoutingStrategy {
    double calculateRouteImpact(Shipment shipment);
    String getStrategyName();
}