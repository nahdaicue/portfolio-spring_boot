package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.Project;
import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.repositorys.ProjectRepository;
import com.nahuelcuello.portfolio.repositorys.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }
    
    // CREATE
    @Override
    @Transactional
    public Project save(Project project) {
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        project.setUser(user);
        return projectRepository.save(project);
    }
    
    // UPDATE
    @Override
    @Transactional 
    public Project update(Long id, Project project) {
        Project existingProject = findById(id);
        existingProject.setNameProject(project.getNameProject());
        existingProject.setDescription(project.getDescription());
        existingProject.setLanguages(project.getLanguages());
        existingProject.setImageUrls(project.getImageUrls());
        existingProject.setUrlDemo(project.getUrlDemo());
        existingProject.setUrlGitFront(project.getUrlGitFront());
        existingProject.setUrlGitBack(project.getUrlGitBack());
        existingProject.setUrlPublicFront(project.getUrlPublicFront());
        existingProject.setUrlPublicBack(project.getUrlPublicBack());
        return projectRepository.save(existingProject);
    }
    
    // READ
    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }
    
    // DELETE
    @Override
    @Transactional
    public void deleteById(Long id) {
        Project project = findById(id);
        projectRepository.deleteById(id);
    }
}