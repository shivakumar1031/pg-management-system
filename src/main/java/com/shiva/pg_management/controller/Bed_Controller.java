package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Bed;
import com.shiva.pg_management.service.Bed_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class Bed_Controller {

    @Autowired
    private Bed_Service bedService;


    // Add bed
    @PostMapping("/add")
    public ResponseEntity<Bed> addBed(@RequestBody Bed bed) {

        return ResponseEntity.ok(bedService.addBed(bed));
    }


    // Get all beds
    @GetMapping("/getAll")
    public ResponseEntity<List<Bed>> getAllBeds() {

        return ResponseEntity.ok(bedService.getAllBeds());
    }


    // Get bed by ID
    @GetMapping("/get/{bedId}")
    public ResponseEntity<Bed> getBedById(
            @PathVariable Integer bedId) {

        return ResponseEntity.ok(bedService.getBedById(bedId));
    }


    // Update bed
    @PutMapping("/update/{bedId}")
    public ResponseEntity<Bed> updateBed(
            @PathVariable Integer bedId,
            @RequestBody Bed bed) {

        return ResponseEntity.ok(
                bedService.updateBed(bedId, bed)
        );
    }


    // Delete bed
    @DeleteMapping("/delete/{bedId}")
    public ResponseEntity<String> deleteBed(
            @PathVariable Integer bedId) {

        return ResponseEntity.ok(
                bedService.deleteBed(bedId)
        );
    }
}