package com.kas.security_agency.controller;

import com.kas.security_agency.domain.Employee;
import com.kas.security_agency.service.EmployeeService;
import lombok.Getter;
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
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Employee newEmployee = employeeService.saveOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long employee_id){
        Employee employee = employeeService.findById(employee_id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PutMapping("/{employee_id}")
    public ResponseEntity<?> putEmployeeById(@RequestBody Employee employee){
        Employee newEmployee = employeeService.saveOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long employee_id){
        employeeService.deleteById(employee_id);
        return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
    }
}
