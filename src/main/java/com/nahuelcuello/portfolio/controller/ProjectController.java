package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.entitys.Project;
import com.nahuelcuello.portfolio.services.ProjectServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    // GET ALL
    @GetMapping
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectService.findById(id);
    }

    // CREATE
    @PostMapping
    public Project create(@RequestBody Project project) {
        return projectService.save(project);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Project update(
            @PathVariable Long id,
            @RequestBody Project project
    ) {
        return projectService.update(id, project);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.deleteById(id);
    }

}
