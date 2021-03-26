package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Client;
import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.service.ClientService;
import com.kas.security_agency.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@Valid @RequestBody Client client, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Client newClient = clientService.saveOrUpdateClient(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{client_id}")
    public ResponseEntity<?> getClientById(@PathVariable Long client_id){
        Client client = clientService.findById(client_id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PutMapping("/{client_id}")
    public ResponseEntity<?> putClientById(@RequestBody Client client){
        Client newClient = clientService.saveOrUpdateClient(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.OK);
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long client_id){
        clientService.deleteById(client_id);
        return new ResponseEntity<String>("Client deleted", HttpStatus.OK);
    }
}

