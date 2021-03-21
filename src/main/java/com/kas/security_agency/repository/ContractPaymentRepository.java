package com.kas.security_agency.repository;

import com.kas.security_agency.entity.ContractPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractPaymentRepository extends JpaRepository<ContractPayment, Long> {

    Optional<ContractPayment> getById(Long id);

}