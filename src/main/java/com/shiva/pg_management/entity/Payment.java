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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    private Double amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}