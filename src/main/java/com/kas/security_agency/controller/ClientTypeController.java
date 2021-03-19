package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Client;
import com.kas.security_agency.entity.ClientType;
import com.kas.security_agency.service.ClientService;
import com.kas.security_agency.service.ClientTypeService;
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
@RequestMapping("/api/clientType")
@CrossOrigin
public class ClientTypeController {

    @Autowired
    private ClientTypeService clientTypeService;

    @PostMapping("")
    public ResponseEntity<?> addClient(@Valid @RequestBody ClientType clientType, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ClientType newClientType = clientTypeService.saveOrUpdateClientType(clientType);
        return new ResponseEntity<ClientType>(newClientType, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ClientType> getAllClients(){
        return clientTypeService.findAll();
    }

    @GetMapping("/{clientType_id}")
    public ResponseEntity<?> getClientById(@PathVariable Long clientType_id){
        ClientType clientType = clientTypeService.findById(clientType_id);
        return new ResponseEntity<ClientType>(clientType, HttpStatus.OK);
    }

    @PutMapping("/{clientType_id}")
    public ResponseEntity<?> putClientById(@RequestBody ClientType clientType){
        ClientType newClientType = clientTypeService.saveOrUpdateClientType(clientType);
        return new ResponseEntity<ClientType>(newClientType, HttpStatus.OK);
    }

    @DeleteMapping("/{clientType_id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long clientType_id){
        clientTypeService.deleteById(clientType_id);
        return new ResponseEntity<String>("Client deleted", HttpStatus.OK);
    }
}

