package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.Project;
import com.nahuelcuello.portfolio.repositorys.ProjectRepository;
import com.nahuelcuello.portfolio.repositorys.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

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
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    // UPDATE
    @Override
    public Project update(Long id, Project project) {
        Project existingProject = findById(id);

        existingProject.setNameProject(project.getNameProject());
        existingProject.setDescription(project.getDescription());
        existingProject.setLanguages(project.getLanguages());
        existingProject.setUrlDemo(project.getUrlDemo());
        existingProject.setUrlGitFront(project.getUrlGitFront());
        existingProject.setUrlGitBack(project.getUrlGitBack());
        existingProject.setUrlPublicFront(project.getUrlPublicFront());
        existingProject.setUrlPublicBack(project.getUrlPublicBack());

        return projectRepository.save(existingProject);
    }

    // READ
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    // DELETE
    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
