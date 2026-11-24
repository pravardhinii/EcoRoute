package com.ecoroute.calculator;

import com.ecoroute.model.Shipment;
import com.ecoroute.model.TransportLeg;
import com.ecoroute.strategy.GreenestRouteStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmissionCalculatorTest {

    @Test
    void testGreenestRouteCalculation() {
        TransportLeg leg = new TransportLeg("ELECTRIC_FREIGHT", 100.0, 0.02);
        Shipment shipment = new Shipment("TRK-001", 500.0, List.of(leg));
        
        EmissionCalculator calculator = new EmissionCalculator(new GreenestRouteStrategy());
        double emissions = calculator.computeTotalEmissions(shipment);

        assertEquals(1000.0, emissions); // 100 * 500 * 0.02
    }
}