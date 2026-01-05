
package com.nahuelcuello.portfolio.mapper;

import com.nahuelcuello.portfolio.DTO.project.ProjectResponseDTO;
import com.nahuelcuello.portfolio.entitys.Project;

public class ProjectMapper {
    
    public static ProjectResponseDTO toDto (Project project){
    
        ProjectResponseDTO dto = new ProjectResponseDTO();

        dto.setId(project.getId());
        dto.setNameProject(project.getNameProject());
        dto.setDescription(project.getDescription());
        dto.setLanguages(project.getLanguages());
        dto.setUrlDemo(project.getUrlDemo());
        dto.setImageUrls(project.getImageUrls());
        dto.setUrlGitFront(project.getUrlGitFront());
        dto.setUrlGitBack(project.getUrlGitBack());
        dto.setUrlPublicFront(project.getUrlPublicFront());
        dto.setUrlPublicBack(project.getUrlPublicBack());

        return dto;
        
    }
    
}
