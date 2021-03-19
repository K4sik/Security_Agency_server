package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.entity.Status;
import com.kas.security_agency.service.StatusService;
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
@RequestMapping("/api/status")
@CrossOrigin
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("")
    public ResponseEntity<?> addStatus(@Valid @RequestBody Status status, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Status newStatus = statusService.saveOrUpdateStatus(status);
        return new ResponseEntity<Status>(newStatus, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Status> getAllStatuses(){
        return statusService.findAll();
    }

    @GetMapping("/{status_id}")
    public ResponseEntity<?> getStatusById(@PathVariable Long status_id){
        Status status = statusService.findById(status_id);
        return new ResponseEntity<Status>(status, HttpStatus.OK);
    }

    @PutMapping("/{status_id}")
    public ResponseEntity<?> putEmployeeById(@RequestBody Status status){
        Status newStatus = statusService.saveOrUpdateStatus(status);
        return new ResponseEntity<Status>(newStatus, HttpStatus.OK);
    }

    @DeleteMapping("/{status_id}")
    public ResponseEntity<?> deleteStatusById(@PathVariable Long status_id){
        statusService.deleteById(status_id);
        return new ResponseEntity<String>("Status deleted", HttpStatus.OK);
    }

}
