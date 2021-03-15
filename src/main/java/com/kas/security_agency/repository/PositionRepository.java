package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
