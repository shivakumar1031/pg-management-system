package com.shiva.pg_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stayId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;
}