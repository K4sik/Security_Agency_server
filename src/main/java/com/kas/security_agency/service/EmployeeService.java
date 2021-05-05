package com.kas.security_agency.service;

import com.kas.security_agency.entity.Employee;
import com.kas.security_agency.exception.EmployeeNotFoundException;
import com.kas.security_agency.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return employeeRepository.getById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Employee> employees = employeeRepository.findAll();

        String path = "D:\\Downloads\\Reports";

        File file = ResourceUtils.getFile("classpath:Reports/Employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created by ", "Roman Kasarab");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Employees.pdf");
//            JasperExportManager.exportReportToPdf(jasperPrint);
        }

        return "Report downloaded to " + path;
    }
}
