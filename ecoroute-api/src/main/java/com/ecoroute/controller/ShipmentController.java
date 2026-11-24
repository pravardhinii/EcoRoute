package com.ecoroute.controller;

import com.ecoroute.dto.ShipmentRequestDto;
import com.ecoroute.entity.ShipmentEntity;
import com.ecoroute.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentEntity> createShipment(@Valid @RequestBody ShipmentRequestDto requestDto) {
        ShipmentEntity saved = shipmentService.processAndSaveShipment(requestDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}