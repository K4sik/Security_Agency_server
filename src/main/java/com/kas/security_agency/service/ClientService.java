package com.kas.security_agency.service;

import com.kas.security_agency.entity.Client;
import com.kas.security_agency.exception.ClientNotFoundException;
import com.kas.security_agency.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.getById(id).orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Client client = findById(id);
        clientRepository.delete(client);
    }
}
