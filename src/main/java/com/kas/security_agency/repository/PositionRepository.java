package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> getById(Long id);

}
