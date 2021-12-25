package com.company.company.services;

import com.company.company.classes.Job;
import com.company.company.classes.Project;
import com.company.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServices {

    @Autowired
    private JobRepository jobRepository;


    public List<Job> getJobs() {
        List<Job> jobs=new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);
        return jobs;
    }

    public Optional<Job> getJob(Long id) {
        return jobRepository.findById(id);
    }

    public void addJob(Job job) {
        job.setCreated_date(LocalDate.now());
        job.setUpdated_date(LocalDate.now());
        jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Transactional
    public void updateJob(Job job) {
        Job jo= jobRepository.findById(job.getId())
                .orElseThrow(()-> new IllegalStateException (
                        "Department with id "+job.getId()+" does not exit"));
        jo.setJob_name(job.getJob_name());
        jo.setUpdated_date(LocalDate.now());
        //jobRepository.save(job);
    }
}
