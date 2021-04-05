package com.kas.security_agency.controller;

import com.kas.security_agency.entity.ClientType;
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
@RequestMapping("/api/client_type")
@CrossOrigin
public class ClientTypeController {

    @Autowired
    private ClientTypeService clientTypeService;

    @PostMapping("/add")
    public ResponseEntity<?> addClientType(@Valid @RequestBody ClientType clientType, BindingResult bindingResult){

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
    public Iterable<ClientType> getAllClientTypes(){
        return clientTypeService.findAll();
    }

    @GetMapping("/{client_type_id}")
    public ResponseEntity<?> getClientTypeById(@PathVariable Long client_type_id){
        ClientType clientType = clientTypeService.findById(client_type_id);
        return new ResponseEntity<ClientType>(clientType, HttpStatus.OK);
    }

    @PutMapping("/{client_type_id}")
    public ResponseEntity<?> putClientTypeById(@RequestBody ClientType clientType){
        ClientType newClientType = clientTypeService.saveOrUpdateClientType(clientType);
        return new ResponseEntity<ClientType>(newClientType, HttpStatus.OK);
    }

    @DeleteMapping("/{client_type_id}")
    public ResponseEntity<?> deleteClientTypeById(@PathVariable Long client_type_id){
        clientTypeService.deleteById(client_type_id);
        return new ResponseEntity<String>("Client deleted", HttpStatus.OK);
    }
}

