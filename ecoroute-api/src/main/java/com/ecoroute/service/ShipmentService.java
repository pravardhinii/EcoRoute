package com.ecoroute.service;

import com.ecoroute.calculator.EmissionCalculator;
import com.ecoroute.config.CarbonProperties;
import com.ecoroute.dto.ShipmentRequestDto;
import com.ecoroute.entity.ShipmentEntity;
import com.ecoroute.exception.CarbonThresholdExceededException;
import com.ecoroute.model.Shipment;
import com.ecoroute.model.TransportLeg;
import com.ecoroute.repository.ShipmentRepository;
import com.ecoroute.strategy.RoutingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentRepository repository;
    private final RoutingStrategy routingStrategy;
    private final CarbonProperties carbonProperties;

    public ShipmentService(ShipmentRepository repository, RoutingStrategy routingStrategy, CarbonProperties carbonProperties) {
        this.repository = repository;
        this.routingStrategy = routingStrategy;
        this.carbonProperties = carbonProperties;
    }

    @Transactional
    public ShipmentEntity processAndSaveShipment(ShipmentRequestDto dto) {
        TransportLeg leg = new TransportLeg("FREIGHT", dto.getDistanceKm(), 0.05);
        Shipment shipment = new Shipment(dto.getTrackingId(), dto.getCargoWeightKg(), List.of(leg));

        EmissionCalculator calculator = new EmissionCalculator(routingStrategy);
        double emissions = calculator.computeTotalEmissions(shipment);

        if (emissions > carbonProperties.getMaxAllowedEmissions()) {
            throw new CarbonThresholdExceededException("Calculated emissions exceed regional regulatory limit.");
        }

        ShipmentEntity entity = new ShipmentEntity(dto.getTrackingId(), dto.getCargoWeightKg(), emissions);
        return repository.save(entity);
    }
}