package com.mikhalenok.monitor.sensors.repository;

import com.mikhalenok.monitor.sensors.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
}
