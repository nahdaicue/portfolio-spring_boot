
package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.Project;
import java.util.List;

interface ProjectService {
    
    Project save(Project project);

    Project update(Long id, Project project);

    List<Project> findAll();

    Project findById(Long id);

    void deleteById(Long id);
    
}
