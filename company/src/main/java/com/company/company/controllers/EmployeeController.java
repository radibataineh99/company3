package com.company.company.controllers;

import com.company.company.classes.Employee;
import com.company.company.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/services")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @RequestMapping(value = "/employee/getemployees",method = RequestMethod.POST)
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(employeeServices.getEmployees(), HttpStatus.OK);
    }
    @RequestMapping(value = "/employee/getemployee",method = RequestMethod.POST)
    public ResponseEntity<Optional<Employee>> getEmployee(@RequestBody Long id){
        return new ResponseEntity<Optional<Employee>>(employeeServices.getEmployee(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/addemployee",method = RequestMethod.POST)
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
        employeeServices.addEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/deleteemployee",method = RequestMethod.POST)
    public ResponseEntity<Void> deleteEmployee(@RequestBody Long id){
        employeeServices.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/updateemployee",method = RequestMethod.POST)
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee){
        employeeServices.updateEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
