
package com.nahuelcuello.portfolio.DTO.user;

import com.nahuelcuello.portfolio.DTO.project.ProjectResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDTO {
    
    private Long id;
    private String name;
    private String urlImg;
    private List<ProjectResponseDTO> projects;
    
}
