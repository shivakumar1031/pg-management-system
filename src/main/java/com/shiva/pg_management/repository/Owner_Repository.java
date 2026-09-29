package com.shiva.pg_management.repository;

import com.shiva.pg_management.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Owner_Repository extends JpaRepository<Owner,Integer> {

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);
}
