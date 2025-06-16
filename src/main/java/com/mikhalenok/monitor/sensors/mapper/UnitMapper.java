package com.mikhalenok.monitor.sensors.mapper;

import com.mikhalenok.monitor.sensors.dto.unit.UnitRq;
import com.mikhalenok.monitor.sensors.dto.unit.UnitRs;
import com.mikhalenok.monitor.sensors.model.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnitMapper {
    UnitRs toUnitDto(Unit unit);
    Unit toUnit(UnitRq unit);
}
