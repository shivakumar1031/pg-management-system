package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.PG;
import com.shiva.pg_management.service.PG_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pg")
public class PG_Controller {

    @Autowired
    private PG_Service pgService;


    // 1. Add PG
    @PostMapping("/add")
    public ResponseEntity<PG> addPgDetails(@RequestBody PG pg) {

        return ResponseEntity.ok(pgService.addPg(pg));
    }


    // 2. Get all PGs
    @GetMapping("/getAll")
    public ResponseEntity<List<PG>> getAllPgs() {

        return ResponseEntity.ok(pgService.getAllPgs());
    }


    // 3. Get PG by ID
    @GetMapping("/get/{pgId}")
    public ResponseEntity<PG> getPgById(@PathVariable Integer pgId) {

        return ResponseEntity.ok(pgService.getPgById(pgId));
    }


    // 4. Update PG
    @PutMapping("/update/{pgId}")
    public ResponseEntity<PG> updatePg(
            @PathVariable Integer pgId,
            @RequestBody PG pg) {

        return ResponseEntity.ok(pgService.updatePg(pgId, pg));
    }


    // 5. Delete PG
    @DeleteMapping("/delete/{pgId}")
    public ResponseEntity<String> deletePg(@PathVariable Integer pgId) {

        return ResponseEntity.ok(pgService.deletePg(pgId));
    }
}