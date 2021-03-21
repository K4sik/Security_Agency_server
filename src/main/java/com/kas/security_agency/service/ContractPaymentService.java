package com.kas.security_agency.service;

import com.kas.security_agency.entity.ContractPayment;
import com.kas.security_agency.exception.ContractPaymentNotFoundException;
import com.kas.security_agency.repository.ContractPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractPaymentService {

    @Autowired
    private ContractPaymentRepository contractPaymentRepository;

    public ContractPayment saveOrUpdateContractPayment(ContractPayment contractPayment) {
        return contractPaymentRepository.save(contractPayment);
    }

    public Iterable<ContractPayment> findAll() {
        return contractPaymentRepository.findAll();
    }

    public ContractPayment findById(Long id) {
        return contractPaymentRepository.getById(id).orElseThrow(() -> new ContractPaymentNotFoundException("Contract Payment with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        ContractPayment contractPayment = findById(id);
        contractPaymentRepository.delete(contractPayment);
    }

}
