package com.shiva.pg_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pgId;

    private String name;
    private String address;
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
