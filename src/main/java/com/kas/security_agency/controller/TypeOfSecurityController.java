package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.entity.TypeOfSecurity;
import com.kas.security_agency.service.TypeOfSecurityService;
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
@RequestMapping("/api/type_of_security")
@CrossOrigin
public class TypeOfSecurityController {

    @Autowired
    private TypeOfSecurityService typeOfSecurityService;

    @PostMapping("")
    public ResponseEntity<?> addTypeOfSecurity(@Valid @RequestBody TypeOfSecurity typeOfSecurity, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        TypeOfSecurity newTypeOfSecurity = typeOfSecurityService.saveOrUpdateTypeOfSecurity(typeOfSecurity);
        return new ResponseEntity<TypeOfSecurity>(newTypeOfSecurity, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<TypeOfSecurity> getAllTypeOfSecurities(){
        return typeOfSecurityService.findAll();
    }

    @GetMapping("/{type_of_security_id}")
    public ResponseEntity<?> getTypeOfSecurityById(@PathVariable Long type_of_security_id){
        TypeOfSecurity typeOfSecurity = typeOfSecurityService.findById(type_of_security_id);
        return new ResponseEntity<TypeOfSecurity>(typeOfSecurity, HttpStatus.OK);
    }

    @PutMapping("/{type_of_security_id}")
    public ResponseEntity<?> putTypeOfSecurityById(@RequestBody TypeOfSecurity typeOfSecurity){
        TypeOfSecurity newTypeOfSecurity = typeOfSecurityService.saveOrUpdateTypeOfSecurity(typeOfSecurity);
        return new ResponseEntity<TypeOfSecurity>(newTypeOfSecurity, HttpStatus.OK);
    }

    @DeleteMapping("/{type_of_security_id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long type_of_security_id){
        typeOfSecurityService.deleteById(type_of_security_id);
        return new ResponseEntity<String>("Type of security deleted", HttpStatus.OK);
    }
}
