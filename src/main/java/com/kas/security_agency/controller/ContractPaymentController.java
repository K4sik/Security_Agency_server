package com.kas.security_agency.controller;

import com.kas.security_agency.entity.ContractPayment;
import com.kas.security_agency.service.ContractPaymentService;
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
@RequestMapping("/api/contractPayment")
@CrossOrigin
public class ContractPaymentController {

    @Autowired
    private ContractPaymentService contractPaymentService;

    @PostMapping("")
    public ResponseEntity<?> addContractPayment(@Valid @RequestBody ContractPayment contractPayment, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ContractPayment newContractPayment = contractPaymentService.saveOrUpdateContractPayment(contractPayment);
        return new ResponseEntity<ContractPayment>(newContractPayment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ContractPayment> getAllContractPayments(){
        return contractPaymentService.findAll();
    }

    @GetMapping("/{contract_payment_id}")
    public ResponseEntity<?> getContractPaymentById(@PathVariable Long contract_payment_id){
        ContractPayment contractPayment = contractPaymentService.findById(contract_payment_id);
        return new ResponseEntity<ContractPayment>(contractPayment, HttpStatus.OK);
    }

    @PutMapping("/{contract_payment_id}")
    public ResponseEntity<?> putClientById(@RequestBody ContractPayment contractPayment){
        ContractPayment newContractPayment = contractPaymentService.saveOrUpdateContractPayment(contractPayment);
        return new ResponseEntity<ContractPayment>(newContractPayment, HttpStatus.OK);
    }

    @DeleteMapping("/{contract_payment_id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long contract_payment_id){
        contractPaymentService.deleteById(contract_payment_id);
        return new ResponseEntity<String>("Contract Payment deleted", HttpStatus.OK);
    }
}
