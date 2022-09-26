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
public class FishPond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Double area;

    private String name;

    private String address;

    private String city;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    private boolean status;

    private Long createUid;

    private Long lastUpdateUid;

}
