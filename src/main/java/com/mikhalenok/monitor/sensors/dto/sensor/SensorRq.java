package com.mikhalenok.monitor.sensors.dto.sensor;

import com.mikhalenok.monitor.sensors.validator.ValidRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record SensorRq(
        @NotBlank
        @Size(min = 3, max = 30)
        String name,

        @NotBlank
        @Size(max = 15)
        String model,

        @ValidRange
        RangeRq range,
        @NotNull
        Long type,
        Long unit,

        @Size(max = 40)
        String location,

        @Size(max = 200)
        String description
) {

}
