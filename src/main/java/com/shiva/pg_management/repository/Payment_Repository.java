package com.shiva.pg_management.repository;

import com.shiva.pg_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Payment_Repository
        extends JpaRepository<Payment, Integer> {
}