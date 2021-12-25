package com.company.company.repositories;

import com.company.company.classes.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
}
