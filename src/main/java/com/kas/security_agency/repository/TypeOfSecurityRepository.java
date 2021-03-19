package com.kas.security_agency.repository;

import com.kas.security_agency.entity.TypeOfSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOfSecurityRepository extends JpaRepository<TypeOfSecurity, Long> {

    Optional<TypeOfSecurity> getById(Long id);

}
