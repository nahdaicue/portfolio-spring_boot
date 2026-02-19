package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.DTO.project.ProjectDTO;
import com.nahuelcuello.portfolio.entitys.Project;
import com.nahuelcuello.portfolio.mapper.ProjectMapper;
import com.nahuelcuello.portfolio.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {
    
    private final ProjectService projectService;
    
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    // GET ALL
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getProjects() {
        List<Project> projects = projectService.findAll();
        List<ProjectDTO> projectDTOs = projects.stream()
                .map(ProjectMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(projectDTOs, HttpStatus.OK);
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) { 
        Project project = projectService.findById(id);
        ProjectDTO projectDTO = ProjectMapper.toDto(project);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }
    
    // CREATE
    @PostMapping
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO projectDTO) {
        Project project = ProjectMapper.toEntity(projectDTO);
        Project savedProject = projectService.save(project);
        ProjectDTO savedDTO = ProjectMapper.toDto(savedProject);
        return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(
            @PathVariable Long id,
            @RequestBody ProjectDTO projectDTO
    ) {
        Project project = ProjectMapper.toEntity(projectDTO);
        Project updatedProject = projectService.update(id, project);
        ProjectDTO updatedDTO = ProjectMapper.toDto(updatedProject);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}