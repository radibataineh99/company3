package com.company.company.controllers;

import com.company.company.classes.Project;
import com.company.company.services.ProjectServices;
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
public class ProjectController {

    @Autowired
    private ProjectServices projectServices;

    @RequestMapping(value = "/project/getprojects",method = RequestMethod.POST)
    public ResponseEntity<List<Project>> getProjects(){
        return new ResponseEntity<List<Project>>(projectServices.getProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/project/getproject",method = RequestMethod.POST)
    public ResponseEntity<Optional<Project>> getProjects(@RequestBody Long id){
        return new ResponseEntity<Optional<Project>>(projectServices.getProject(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/project/addproject",method = RequestMethod.POST)
    public ResponseEntity<Void> addProject(@RequestBody Project project){
        projectServices.addProject(project);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/project/deleteproject",method = RequestMethod.POST)
    public ResponseEntity<Void> deleteProject(@RequestBody Long id){
        projectServices.deleteProject(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/project/updateproject",method = RequestMethod.POST)
    public ResponseEntity<Void> updateProject(@RequestBody Project project){
        projectServices.updateProject(project);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
