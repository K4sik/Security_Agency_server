package com.kas.security_agency.controller;

import com.kas.security_agency.entity.PaymentType;
import com.kas.security_agency.service.PaymentTypeService;
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
@RequestMapping("/api/paymentType")
@CrossOrigin
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @PostMapping("/add")
    public ResponseEntity<?> addPaymentType(@Valid @RequestBody PaymentType paymentType, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        PaymentType newPaymentType = paymentTypeService.saveOrUpdatePaymentType(paymentType);
        return new ResponseEntity<PaymentType>(newPaymentType, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<PaymentType> getAllPaymentTypes(){
        return paymentTypeService.findAll();
    }

    @GetMapping("/{payment_type_id}")
    public ResponseEntity<?> getPaymentTypeById(@PathVariable Long payment_type_id){
        PaymentType paymentType = paymentTypeService.findById(payment_type_id);
        return new ResponseEntity<PaymentType>(paymentType, HttpStatus.OK);
    }

    @PutMapping("/{payment_type_id}")
    public ResponseEntity<?> putClientById(@RequestBody PaymentType paymentType){
        PaymentType newPaymentType = paymentTypeService.saveOrUpdatePaymentType(paymentType);
        return new ResponseEntity<PaymentType>(newPaymentType, HttpStatus.OK);
    }

    @DeleteMapping("/{payment_type_id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long payment_type_id){
        paymentTypeService.deleteById(payment_type_id);
        return new ResponseEntity<String>("Contract Payment deleted", HttpStatus.OK);
    }
}
