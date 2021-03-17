package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
