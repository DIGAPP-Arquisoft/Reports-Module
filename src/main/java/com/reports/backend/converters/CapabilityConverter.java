package com.reports.backend.converters;

import com.reports.backend.data.CapabilityData;
import com.reports.backend.entities.Capability;

public class CapabilityConverter extends Converter<Capability, CapabilityData> {

    @Override
    public Capability toEntity(CapabilityData object) {
        return object == null ? null
                : Capability.builder()
                        .CapabilityID(object.getCapabilityID())
                        .OcupationType(object.getOcupationType())
                        .build();
    }

    @Override
    public CapabilityData toData(Capability object) {
        return object == null ? null
                : CapabilityData.builder()
                        .CapabilityID(object.getCapabilityID())
                        .OcupationType(object.getOcupationType())
                        .build();
    }
}
