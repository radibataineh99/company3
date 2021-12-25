package com.company.company.services;

import com.company.company.classes.Department;
import com.company.company.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        List<Department> departments =new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public void addDepartment(Department department) {
        department.setCreated_date(LocalDate.now());
        department.setUpdated_date(LocalDate.now());
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Transactional
    public void updateDepartment(Department department) {
        Department dep= departmentRepository.findById(department.getId())
                .orElseThrow(()-> new IllegalStateException (
                        "Department with id "+department.getId()+" does not exit"));

        dep.setDepartment_name(department.getDepartment_name());
        dep.setUpdated_date(LocalDate.now());
        //departmentRepository.save(department);
    }

    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }
}
