package com.kas.security_agency.service;

import com.kas.security_agency.entity.TypeOfSecurity;
import com.kas.security_agency.exception.TypeOfSecurityNotFoundException;
import com.kas.security_agency.repository.TypeOfSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfSecurityService {

    @Autowired
    private TypeOfSecurityRepository typeOfSecurityRepository;

    public TypeOfSecurity saveOrUpdateTypeOfSecurity(TypeOfSecurity typeOfSecurity){
        return typeOfSecurityRepository.save(typeOfSecurity);
    }

    public Iterable<TypeOfSecurity> findAll(){
        return typeOfSecurityRepository.findAll();
    }

    public TypeOfSecurity findById(Long id){
        return typeOfSecurityRepository.getById(id).orElseThrow(() -> new TypeOfSecurityNotFoundException("Type Of Security with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        TypeOfSecurity typeOfSecurity = findById(id);
        typeOfSecurityRepository.delete(typeOfSecurity);
    }

}
