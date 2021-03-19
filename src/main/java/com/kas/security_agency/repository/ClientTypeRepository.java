package com.kas.security_agency.repository;

import com.kas.security_agency.entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {

    Optional<ClientType> getById(Long id);

}
