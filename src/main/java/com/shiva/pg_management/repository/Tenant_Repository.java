package com.shiva.pg_management.repository;

import com.shiva.pg_management.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tenant_Repository extends JpaRepository<Tenant, Integer> {
}