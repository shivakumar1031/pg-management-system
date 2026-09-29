package com.shiva.pg_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedId;

    private String bedNumber;

    private String bedStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}