package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.Tenant;
import com.shiva.pg_management.repository.Tenant_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tenant_Service {

    @Autowired
    private Tenant_Repository tenantRepository;

    public Tenant addTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenantById(Integer tenantId) {
        return tenantRepository.findById(tenantId).orElse(null);
    }

    public Tenant updateTenant(Integer tenantId, Tenant tenant) {

        Tenant existingTenant =
                tenantRepository.findById(tenantId).orElse(null);

        if (existingTenant != null) {

            existingTenant.setName(tenant.getName());
            existingTenant.setMobileNumber(tenant.getMobileNumber());
            existingTenant.setEmergencyNumber(tenant.getEmergencyNumber());
            existingTenant.setGovernmentId(tenant.getGovernmentId());

            return tenantRepository.save(existingTenant);
        }

        return null;
    }

    public String deleteTenant(Integer tenantId) {

        if (tenantRepository.existsById(tenantId)) {
            tenantRepository.deleteById(tenantId);
            return "Tenant deleted successfully";
        }

        return "Tenant not found";
    }
}