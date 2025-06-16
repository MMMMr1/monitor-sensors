package com.mikhalenok.monitor.sensors.dto.sensortype;

import jakarta.validation.constraints.NotNull;


public record SensorTypeRq(@NotNull String name) {
}