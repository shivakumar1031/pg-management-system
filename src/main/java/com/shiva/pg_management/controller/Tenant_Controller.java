package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Tenant;
import com.shiva.pg_management.service.Tenant_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class Tenant_Controller {

    @Autowired
    private Tenant_Service tenantService;

    @PostMapping("/add")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
        return ResponseEntity.ok(tenantService.addTenant(tenant));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tenant>> getAllTenants() {
        return ResponseEntity.ok(tenantService.getAllTenants());
    }

    @GetMapping("/get/{tenantId}")
    public ResponseEntity<Tenant> getTenantById(
            @PathVariable Integer tenantId) {

        return ResponseEntity.ok(tenantService.getTenantById(tenantId));
    }

    @PutMapping("/update/{tenantId}")
    public ResponseEntity<Tenant> updateTenant(
            @PathVariable Integer tenantId,
            @RequestBody Tenant tenant) {

        return ResponseEntity.ok(
                tenantService.updateTenant(tenantId, tenant)
        );
    }

    @DeleteMapping("/delete/{tenantId}")
    public ResponseEntity<String> deleteTenant(
            @PathVariable Integer tenantId) {

        return ResponseEntity.ok(
                tenantService.deleteTenant(tenantId)
        );
    }
}