package com.fishpond.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AquaticInformationOfDevice {
    private String deviceId;

    private Double temperature;

    private Double humidity;

    private Double ph;

    private Double dissolvedOxygen;
}
