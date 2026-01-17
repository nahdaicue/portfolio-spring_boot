package com.nahuelcuello.portfolio.mapper;

import com.nahuelcuello.portfolio.DTO.project.ProjectDTO;
import com.nahuelcuello.portfolio.entitys.Project;

public class ProjectMapper {

    public static ProjectDTO toDto(Project project) {
        if (project == null) {
            return null;
        }
        return new ProjectDTO(
                project.getId(),
                project.getNameProject(),
                project.getDescription(),
                project.getLanguages(),
                project.getUrlDemo(),
                project.getImageUrls(),
                project.getUrlGitFront(),
                project.getUrlGitBack(),
                project.getUrlPublicFront(),
                project.getUrlPublicBack()
        );
    }

    public static Project toEntity(ProjectDTO dto) {
        if (dto == null) {
            return null;
        }

        Project project = new Project();
        project.setNameProject(dto.getNameProject());
        project.setDescription(dto.getDescription());
        project.setLanguages(dto.getLanguages());
        project.setUrlDemo(dto.getUrlDemo());
        project.setImageUrls(dto.getImageUrls());
        project.setUrlGitFront(dto.getUrlGitFront());
        project.setUrlGitBack(dto.getUrlGitBack());
        project.setUrlPublicFront(dto.getUrlPublicFront());
        project.setUrlPublicBack(dto.getUrlPublicBack());

        return project;
    }

}
