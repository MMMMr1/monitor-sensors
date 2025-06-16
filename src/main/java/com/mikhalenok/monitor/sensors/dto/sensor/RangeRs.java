package com.mikhalenok.monitor.sensors.dto.sensor;


import com.fasterxml.jackson.annotation.JsonView;
import com.mikhalenok.monitor.sensors.dto.view.Views;

public record RangeRs(
        @JsonView(Views.Public.class) int from,
        @JsonView(Views.Public.class) int to) {
}
