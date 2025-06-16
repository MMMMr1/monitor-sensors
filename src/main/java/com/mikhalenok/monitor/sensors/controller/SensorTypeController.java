package com.mikhalenok.monitor.sensors.controller;

import com.mikhalenok.monitor.sensors.aspect.Log;
import com.mikhalenok.monitor.sensors.dto.sensortype.SensorTypeRs;
import com.mikhalenok.monitor.sensors.dto.sensortype.SensorTypeRq;
import com.mikhalenok.monitor.sensors.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/types")
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    @GetMapping
    public List<SensorTypeRs> getTypes() {
        return sensorTypeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public SensorTypeRs getType(@PathVariable Long id) {
        return sensorTypeService.getType(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SensorTypeRs saveType(@RequestBody SensorTypeRq sensorTypeRq) {
        return sensorTypeService.saveType(sensorTypeRq);
    }

    @PatchMapping("/{id}/name")
    public SensorTypeRs updateTypeName(@PathVariable Long id, @RequestParam String newName) {
        return sensorTypeService.updateTypeName(id, newName);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteType(@PathVariable Long id) {
        sensorTypeService.deleteType(id);
    }
}