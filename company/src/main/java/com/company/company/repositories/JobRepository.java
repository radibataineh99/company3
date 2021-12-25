package com.company.company.repositories;

import com.company.company.classes.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
}
