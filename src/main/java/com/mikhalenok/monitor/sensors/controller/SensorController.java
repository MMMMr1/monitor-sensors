package com.mikhalenok.monitor.sensors.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mikhalenok.monitor.sensors.aspect.Log;
import com.mikhalenok.monitor.sensors.dto.sensor.SensorRq;
import com.mikhalenok.monitor.sensors.dto.sensor.SensorRs;
import com.mikhalenok.monitor.sensors.dto.sensor.SensorSearchRq;
import com.mikhalenok.monitor.sensors.dto.sensor.SensorSearchRs;
import com.mikhalenok.monitor.sensors.dto.view.Views;
import com.mikhalenok.monitor.sensors.service.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;

    @GetMapping
    @JsonView(Views.Public.class)
    public List<SensorRs> getSensors() {
        return sensorService.getSensors();
    }

    @GetMapping("/admin")
    @JsonView(Views.Admin.class)
    public List<SensorRs> getSensorsForAdmin() {
        return sensorService.getSensors();
    }

    @GetMapping("/search")
    public List<SensorSearchRs> searchSensors(@RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "limit", defaultValue = "50") int limit,
                                              @RequestBody @Valid SensorSearchRq sensorSearchRq) {
        return sensorService.searchSensors(page, limit, sensorSearchRq);
    }

    @GetMapping("/{id}")
    public SensorRs getSensor(@PathVariable Long id) {
        return sensorService.getSensor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveSensor(@RequestBody @Valid SensorRq sensor) {
        return sensorService.saveSensor(sensor);
    }

    @PutMapping("/{id}")
    public SensorRs updateSensor(@PathVariable Long id, @RequestBody @Valid SensorRq sensor) {
        return sensorService.updateSensor(id, sensor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUnit(@PathVariable Long id) {
        sensorService.deleteSensor(id);
    }
}
