package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Owner;
import com.shiva.pg_management.service.Owner_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class Owner_Controller {
    @Autowired
    private Owner_Service ownerService;

    // Add owner
    @PostMapping("/add")
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    // Get all owners
    @GetMapping("/all")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    // Get owner by ID
    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable Integer ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    // Update owner
    @PutMapping("/{ownerId}")
    public Owner updateOwner(
            @PathVariable Integer ownerId,
            @RequestBody Owner owner) {

        return ownerService.updateOwner(ownerId, owner);
    }

    // Delete owner
    @DeleteMapping("/{ownerId}")
    public String deleteOwner(@PathVariable Integer ownerId) {

        ownerService.deleteOwner(ownerId);

        return "Owner deleted successfully";
    }
}
