
package com.nahuelcuello.portfolio.DTO.userDTO;

import com.nahuelcuello.portfolio.DTO.projectDTO.ProjectDTO;
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
    private String email;
    private List<ProjectDTO> projects;
    
}
