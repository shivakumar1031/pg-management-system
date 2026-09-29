package com.shiva.pg_management.repository;

import com.shiva.pg_management.entity.PG;
import com.shiva.pg_management.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PG_Repository extends JpaRepository<PG,Integer> {
}
