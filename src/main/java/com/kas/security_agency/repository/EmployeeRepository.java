package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Employee getById(Long id);

    Optional<Employee> getById(Long id);

}
