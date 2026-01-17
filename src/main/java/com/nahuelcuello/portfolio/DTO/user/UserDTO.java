
package com.nahuelcuello.portfolio.DTO.user;

import com.nahuelcuello.portfolio.DTO.project.ProjectDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    private Long id;
    private String name;
    private String urlImg;
    private List<ProjectDTO> projects;
    
}
