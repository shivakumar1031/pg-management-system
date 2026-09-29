package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.PG;
import com.shiva.pg_management.repository.PG_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PG_Service {

    @Autowired
    private PG_Repository pgRepository;


    // 1. Add PG
    public PG addPg(PG pg) {
        return pgRepository.save(pg);
    }


    // 2. Get all PGs
    public List<PG> getAllPgs() {
        return pgRepository.findAll();
    }


    // 3. Get PG by ID
    public PG getPgById(Integer pgId) {
        return pgRepository.findById(pgId).orElse(null);
    }


    // 4. Update PG
    public PG updatePg(Integer pgId, PG pg) {

        PG existingPg = pgRepository.findById(pgId).orElse(null);

        if (existingPg != null) {

            existingPg.setName(pg.getName());
            existingPg.setAddress(pg.getAddress());
            existingPg.setContactNumber(pg.getContactNumber());

            return pgRepository.save(existingPg);
        }

        return null;
    }


    // 5. Delete PG
    public String deletePg(Integer pgId) {

        if (pgRepository.existsById(pgId)) {

            pgRepository.deleteById(pgId);

            return "PG deleted successfully";
        }

        return "PG not found";
    }
}