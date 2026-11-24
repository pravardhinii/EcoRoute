package com.ecoroute.repository;

import com.ecoroute.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Long> {
    // Keyword Derivation Query
    List<ShipmentEntity> findByTotalEmissionsLessThan(double maxEmission);
}