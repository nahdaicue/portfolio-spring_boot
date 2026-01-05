
package com.nahuelcuello.portfolio.DTO.project;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDTO {
    
    private Long id;
    private String nameProject;
    private String description;
    private List<String> languages;
    private String urlDemo;
    private List<String> imageUrls;
    private String urlGitFront;
    private String urlGitBack;
    private String urlPublicFront;
    private String urlPublicBack;
    
}
