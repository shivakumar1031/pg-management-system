package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.Bed;
import com.shiva.pg_management.entity.Stay;
import com.shiva.pg_management.entity.Tenant;
import com.shiva.pg_management.repository.Bed_Repository;
import com.shiva.pg_management.repository.Stay_Repository;
import com.shiva.pg_management.repository.Tenant_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stay_Service {

    @Autowired
    private Stay_Repository stayRepository;

    @Autowired
    private Tenant_Repository tenantRepository;

    @Autowired
    private Bed_Repository bedRepository;

    public Stay addStay(Stay stay) {

        Integer tenantId = stay.getTenant().getTenantId();
        Integer bedId = stay.getBed().getBedId();


        Tenant tenant =tenantRepository.findById(tenantId).orElseThrow(()->new RuntimeException("Tenant is not available"));
        Bed bed = bedRepository.findById(bedId).orElseThrow(() -> new RuntimeException("Bed is not available);"));
        // Check bed availability
        if (!bed.getBedStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Bed is not available");
        }

        stay.setTenant(tenant);
        stay.setBed(bed);

        bed.setBedStatus("OCCUPIED");
        bedRepository.save(bed);

        return stayRepository.save(stay);
    }

    public List<Stay> getAllStays() {

        return stayRepository.findAll();
    }

    public Stay getStayById(Integer stayId) {

        return stayRepository.findById(stayId).orElse(null);
    }

    public Stay updateStay(Integer stayId, Stay stay) {

        Stay existingStay =
                stayRepository.findById(stayId).orElse(null);

        if (existingStay != null) {

            existingStay.setCheckInDate(stay.getCheckInDate());
            existingStay.setCheckOutDate(stay.getCheckOutDate());

            Integer tenantId = stay.getTenant().getTenantId();
            Integer bedId = stay.getBed().getBedId();

            Tenant tenant =
                    tenantRepository.findById(tenantId).orElse(null);

            Bed bed =
                    bedRepository.findById(bedId).orElse(null);

            existingStay.setTenant(tenant);
            existingStay.setBed(bed);

            return stayRepository.save(existingStay);
        }

        return null;
    }

    public String deleteStay(Integer stayId) {

        if (stayRepository.existsById(stayId)) {
            stayRepository.deleteById(stayId);
            return "Stay deleted successfully";
        }

        return "Stay not found";
    }


    public Stay checkout(Integer stayId) {

        Stay stay =
                stayRepository.findById(stayId).orElse(null);

        if (stay == null) {
            return null;
        }

        // Set checkout date
        stay.setCheckOutDate(java.time.LocalDate.now());

        // Make bed available
        Bed bed = stay.getBed();
        bed.setBedStatus("AVAILABLE");

        bedRepository.save(bed);

        return stayRepository.save(stay);
    }
}