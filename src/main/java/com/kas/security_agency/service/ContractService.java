package com.kas.security_agency.service;

import com.kas.security_agency.entity.Contract;
import com.kas.security_agency.exception.ContractNotFoundException;
import com.kas.security_agency.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract saveOrUpdateContract(Contract contract){
        return contractRepository.save(contract);
    }

    public Iterable<Contract> findAll(){
        return contractRepository.findAll();
    }

    public Contract findById(Long id){
        return contractRepository.getById(id).orElseThrow(() -> new ContractNotFoundException("Employee with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Contract contract = findById(id);
        contractRepository.delete(contract);
    }
}
