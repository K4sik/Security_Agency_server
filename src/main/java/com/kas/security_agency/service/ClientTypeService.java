package com.kas.security_agency.service;

import com.kas.security_agency.entity.ClientType;
import com.kas.security_agency.exception.ClientTypeNotFoundException;
import com.kas.security_agency.repository.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientTypeService {

    @Autowired
    private ClientTypeRepository clientTypeRepository;

    public ClientType saveOrUpdateClientType(ClientType clientType){
        return  clientTypeRepository.save(clientType);
    }

    public Iterable<ClientType> findAll(){
        return clientTypeRepository.findAll();
    }

    public ClientType findById(Long id){
        return clientTypeRepository.getById(id).orElseThrow(() -> new ClientTypeNotFoundException("ClientType with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        ClientType clientType = findById(id);
        clientTypeRepository.delete(clientType);
    }

}
