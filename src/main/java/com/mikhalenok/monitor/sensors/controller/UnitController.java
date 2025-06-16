package com.mikhalenok.monitor.sensors.controller;

import com.mikhalenok.monitor.sensors.aspect.Log;
import com.mikhalenok.monitor.sensors.dto.unit.UnitRs;
import com.mikhalenok.monitor.sensors.dto.unit.UnitRq;
import com.mikhalenok.monitor.sensors.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public List<UnitRs> getUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public UnitRs getUnit(@PathVariable Long id) {
        return unitService.getUnit(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UnitRs saveUnit(@RequestBody UnitRq unitRq) {
        return unitService.saveUnit(unitRq);
    }

    @PatchMapping("/{id}/name")
    public UnitRs updateUnitName(@PathVariable Long id, @RequestParam String newName) {
        return unitService.updateUnitName(id, newName);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
    }
}