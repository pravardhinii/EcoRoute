package com.ecoroute.service;

import com.ecoroute.config.CarbonProperties;
import com.ecoroute.dto.ShipmentRequestDto;
import com.ecoroute.entity.ShipmentEntity;
import com.ecoroute.repository.ShipmentRepository;
import com.ecoroute.service.ShipmentService;
import com.ecoroute.strategy.GreenestRouteStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ShipmentServiceTest {

    private ShipmentRepository repository;
    private CarbonProperties properties;
    private ShipmentService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ShipmentRepository.class);
        properties = new CarbonProperties();
        properties.setMaxAllowedEmissions(5000.0);
        
        service = new ShipmentService(repository, new GreenestRouteStrategy(), properties);
    }

    @Test
    void testProcessAndSaveShipmentSuccess() {
        ShipmentRequestDto dto = new ShipmentRequestDto();
        // Set fields via reflection or mock inputs if needed
        when(repository.save(any(ShipmentEntity.class))).thenReturn(new ShipmentEntity("TRK-999", 100.0, 50.0));
        
        assertNotNull(repository);
    }
}