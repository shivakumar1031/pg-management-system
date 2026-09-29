package com.shiva.pg_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    private String roomNumber;

    private String roomType;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    private PG pg;
}