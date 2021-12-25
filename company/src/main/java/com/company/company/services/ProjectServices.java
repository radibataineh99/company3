package com.company.company.services;

import com.company.company.classes.Department;
import com.company.company.classes.Project;
import com.company.company.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjects() {
        List<Project> projects =new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects;
    }

    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }

    public void addProject(Project project) {
        project.setCreated_date(LocalDate.now());
        project.setUpdated_date(LocalDate.now());
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Transactional
    public void updateProject(Project project) {
        Project pro= projectRepository.findById(project.getId())
                .orElseThrow(()-> new IllegalStateException (
                        "Department with id "+project.getId()+" does not exit"));
        pro.setProject_name(project.getProject_name());
        pro.setUpdated_date(LocalDate.now());
        //projectRepository.save(project);
    }
}
