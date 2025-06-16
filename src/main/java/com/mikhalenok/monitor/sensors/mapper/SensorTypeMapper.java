package com.mikhalenok.monitor.sensors.mapper;

import com.mikhalenok.monitor.sensors.dto.sensortype.SensorTypeRs;
import com.mikhalenok.monitor.sensors.dto.sensortype.SensorTypeRq;
import com.mikhalenok.monitor.sensors.model.SensorType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SensorTypeMapper {
    SensorTypeRs toSensorTypeRs(SensorType sensorType);
    SensorType toSensorType(SensorTypeRq sensorTypeRq);
}
