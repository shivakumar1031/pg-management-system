package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.Owner;
import com.shiva.pg_management.repository.Owner_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Owner_Service {
    @Autowired
    private Owner_Repository ownerRepository;

    // Add owner
    public Owner addOwner(Owner owner) {
        if (ownerRepository.existsByEmail(owner.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        if (ownerRepository.existsByMobile(owner.getMobile())) {
            throw new RuntimeException("Mobile number already registered");
        }
        return ownerRepository.save(owner);
    }

    // Get all owners
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    // Get owner by ID
    public Owner getOwnerById(Integer ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    // Update owner
    public Owner updateOwner(Integer ownerId, Owner owner) {

        Owner existingOwner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        existingOwner.setName(owner.getName());
        existingOwner.setMobile(owner.getMobile());
        existingOwner.setEmail(owner.getEmail());

        return ownerRepository.save(existingOwner);
    }

    // Delete owner
    public void deleteOwner(Integer ownerId) {

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        ownerRepository.delete(owner);
    }
}
