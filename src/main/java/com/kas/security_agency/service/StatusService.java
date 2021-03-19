package com.kas.security_agency.service;

import com.kas.security_agency.entity.Status;
import com.kas.security_agency.exception.StatusNotFoundException;
import com.kas.security_agency.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status saveOrUpdateStatus(Status status){
        return statusRepository.save(status);
    }

    public Iterable<Status> findAll(){
        return statusRepository.findAll();
    }

    public Status findById(Long id){
        return statusRepository.getById(id).orElseThrow(() -> new StatusNotFoundException("Status with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Status status = findById(id);
        statusRepository.delete(status);
    }
}
