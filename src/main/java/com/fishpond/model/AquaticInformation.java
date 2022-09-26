package com.fishpond.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class AquaticInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    private Double humidity;

    private Double ph;

    private Double dissolvedOxygen;

    @ManyToOne
    private Device device;

    private LocalDateTime createDate;

    private String evaluation;


}
