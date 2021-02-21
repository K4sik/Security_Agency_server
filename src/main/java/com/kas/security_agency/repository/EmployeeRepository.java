package com.kas.security_agency.repository;

import com.kas.security_agency.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee getById(Long id);

}
