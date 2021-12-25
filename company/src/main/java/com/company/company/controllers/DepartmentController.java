package com.company.company.controllers;

import com.company.company.classes.Department;
import com.company.company.services.DepartmentService;
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
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department/getdepartments",method = RequestMethod.POST)
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<List<Department>>(departmentService.getDepartments() , HttpStatus.OK);
    }

    @RequestMapping(value = "/department/getdepartment",method = RequestMethod.POST)
    public ResponseEntity<Optional<Department>> getDepartment(@RequestBody Long id){
        return new ResponseEntity<Optional<Department>>(departmentService.getDepartment(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/department/adddepartment",method = RequestMethod.POST)
    public ResponseEntity<Void> addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/department/deletedepartment",method=RequestMethod.POST)
    public ResponseEntity<Void> deleteDepartment(@RequestBody Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/department/updatedepartment",method=RequestMethod.POST)
    public ResponseEntity<Void> updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
