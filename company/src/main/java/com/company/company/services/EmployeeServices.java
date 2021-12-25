package com.company.company.services;

import com.company.company.classes.Employee;
import com.company.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employees =new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee employee) {
        employee.setCreated_date(LocalDate.now());
        employee.setUpdated_date(LocalDate.now());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee) {
        employee.setUpdated_date(LocalDate.now());
        employeeRepository.save(employee);
    }
}
