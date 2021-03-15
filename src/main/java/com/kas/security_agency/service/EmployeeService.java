package com.kas.security_agency.service;

import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.exception.EmployeeNotFoundException;
import com.kas.security_agency.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveOrUpdateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.getById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}
