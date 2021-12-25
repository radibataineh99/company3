package com.company.company.controllers;

import com.company.company.classes.Job;
import com.company.company.services.JobServices;
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
public class JobController {

    @Autowired
    private JobServices jobServices;

    @RequestMapping(value = "/job/getjobs",method = RequestMethod.POST)
    private ResponseEntity<List<Job>> getJobs(){
        return new ResponseEntity<List<Job>>(jobServices.getJobs(), HttpStatus.OK);
    }

    @RequestMapping(value = "/job/getjob",method = RequestMethod.POST)
    private ResponseEntity<Optional<Job>> getJob(@RequestBody Long id){
        return new ResponseEntity<Optional<Job>>(jobServices.getJob(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/job/addjob",method = RequestMethod.POST)
    private ResponseEntity<Void> addJob(@RequestBody Job job)
    {
        jobServices.addJob(job);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/job/deletejob",method = RequestMethod.POST)
    private ResponseEntity<Void> deleteJob(@RequestBody Long id){
        jobServices.deleteJob(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/job/updatejob",method = RequestMethod.POST)
    private ResponseEntity<Void> updateJob(@RequestBody Job job){
        jobServices.updateJob(job);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
