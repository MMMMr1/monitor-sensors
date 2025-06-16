package com.mikhalenok.monitor.sensors.dto.sensor;

import jakarta.validation.constraints.Size;

public record SensorSearchRq (
        @Size(max = 30)
//        @Schema(description = "Filter by sensor name (like '{name}%')", example = "Barometer")
        String name,


        @Size(max = 15)
//        @Schema(description = "Filter by sensor model (like '{model}%')", example = "ac-23")
        String model

        ){
}
