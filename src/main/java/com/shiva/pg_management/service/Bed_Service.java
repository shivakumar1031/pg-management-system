package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.Bed;
import com.shiva.pg_management.entity.Room;
import com.shiva.pg_management.repository.Bed_Repository;
import com.shiva.pg_management.repository.Room_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bed_Service {

    @Autowired
    private Bed_Repository bedRepository;

    @Autowired
    private Room_Repository roomRepository;


    // Add bed
    public Bed addBed(Bed bed) {

        Integer roomId = bed.getRoom().getRoomId();

        Room room = roomRepository.findById(roomId).orElse(null);

        bed.setRoom(room);

        return bedRepository.save(bed);
    }


    // Get all beds
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }


    // Get bed by ID
    public Bed getBedById(Integer bedId) {
        return bedRepository.findById(bedId).orElse(null);
    }


    // Update bed
    public Bed updateBed(Integer bedId, Bed bed) {

        Bed existingBed = bedRepository.findById(bedId).orElse(null);

        if (existingBed != null) {

            existingBed.setBedNumber(bed.getBedNumber());
            existingBed.setBedStatus(bed.getBedStatus());
            existingBed.setRoom(bed.getRoom());

            return bedRepository.save(existingBed);
        }

        return null;
    }


    // Delete bed
    public String deleteBed(Integer bedId) {

        if (bedRepository.existsById(bedId)) {

            bedRepository.deleteById(bedId);

            return "Bed deleted successfully";
        }

        return "Bed not found";
    }
}