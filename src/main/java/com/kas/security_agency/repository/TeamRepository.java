package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> getById(Long id);

}
