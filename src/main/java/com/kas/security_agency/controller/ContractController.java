package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Contract;
import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.service.ContractService;
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
@RequestMapping("/api/contract")
@CrossOrigin
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("")
    public ResponseEntity<?> addContract(@Valid @RequestBody Contract contract, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Contract newContract = contractService.saveOrUpdateContract(contract);
        return new ResponseEntity<Contract>(newContract, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Contract> getAllContracts(){
        return contractService.findAll();
    }

    @GetMapping("/{contract_id}")
    public ResponseEntity<?> getContractById(@PathVariable Long contract_id){
        Contract contract = contractService.findById(contract_id);
        return new ResponseEntity<Contract>(contract, HttpStatus.OK);
    }

    @PutMapping("/{contract_id}")
    public ResponseEntity<?> putContractById(@RequestBody Contract contract){
        Contract newContract = contractService.saveOrUpdateContract(contract);
        return new ResponseEntity<Contract>(newContract, HttpStatus.OK);
    }

    @DeleteMapping("/{contract_id}")
    public ResponseEntity<?> deleteContractById(@PathVariable Long contract_id){
        contractService.deleteById(contract_id);
        return new ResponseEntity<String>("Contract deleted", HttpStatus.OK);
    }
}
