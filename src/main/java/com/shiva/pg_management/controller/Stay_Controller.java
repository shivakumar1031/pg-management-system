package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Stay;
import com.shiva.pg_management.service.Stay_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stay")
public class Stay_Controller {

    @Autowired
    private Stay_Service stayService;

    @PostMapping("/add")
    public ResponseEntity<Stay> addStay(@RequestBody Stay stay) {
        return ResponseEntity.ok(stayService.addStay(stay));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Stay>> getAllStays() {
        return ResponseEntity.ok(stayService.getAllStays());
    }

    @GetMapping("/get/{stayId}")
    public ResponseEntity<Stay> getStayById(
            @PathVariable Integer stayId) {

        return ResponseEntity.ok(stayService.getStayById(stayId));
    }

    @PutMapping("/update/{stayId}")
    public ResponseEntity<Stay> updateStay(
            @PathVariable Integer stayId,
            @RequestBody Stay stay) {

        return ResponseEntity.ok(
                stayService.updateStay(stayId, stay)
        );
    }

    @DeleteMapping("/delete/{stayId}")
    public ResponseEntity<String> deleteStay(
            @PathVariable Integer stayId) {

        return ResponseEntity.ok(
                stayService.deleteStay(stayId)
        );
    }

    @PutMapping("/checkout/{stayId}")
    public ResponseEntity<Stay> checkout(
            @PathVariable Integer stayId) {

        return ResponseEntity.ok(
                stayService.checkout(stayId)
        );
    }
}