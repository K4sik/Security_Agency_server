package com.kas.security_agency.service;

import com.kas.security_agency.domain.Employee;
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
        return employeeRepository.getById(id);
    }

    public void deleteById(Long id){
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}
