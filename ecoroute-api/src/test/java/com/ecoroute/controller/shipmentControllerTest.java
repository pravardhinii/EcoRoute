package com.ecoroute.controller;

import com.ecoroute.dto.ShipmentRequestDto;
import com.ecoroute.entity.ShipmentEntity;
import com.ecoroute.service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShipmentController.class)
class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShipmentService shipmentService;

    @Test
    void testCreateShipmentSuccess() throws Exception {
        // Given valid JSON payload matching DTO constraints
        String requestJson = """
            {
                "trackingId": "TRK-100",
                "cargoWeightKg": 500.0,
                "distanceKm": 200.0
            }
            """;

        ShipmentEntity mockEntity = new ShipmentEntity("TRK-100", 500.0, 5000.0);

        // Mock service behavior
        when(shipmentService.processAndSaveShipment(any(ShipmentRequestDto.class))).thenReturn(mockEntity);

        // When & Then: Perform POST request and verify HTTP 201 Created response
        mockMvc.perform(post("/api/shipments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.trackingId").value("TRK-100"))
                .andExpect(jsonPath("$.cargoWeightKg").value(500.0))
                .andExpect(jsonPath("$.totalEmissions").value(5000.0));
    }

    @Test
    void testCreateShipmentValidationFailure() throws Exception {
        // Given invalid payload (blank ID, negative weight/distance) violating @Valid annotations
        String invalidRequestJson = """
            {
                "trackingId": "",
                "cargoWeightKg": -50.0,
                "distanceKm": 0.0
            }
            """;

        // When & Then: Perform POST request and expect HTTP 400 Bad Request due to validation failure
        mockMvc.perform(post("/api/shipments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequestJson))
                .andExpect(status().isBadRequest());
    }
}