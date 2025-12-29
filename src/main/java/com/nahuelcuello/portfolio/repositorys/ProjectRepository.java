
package com.nahuelcuello.portfolio.repositorys;

import com.nahuelcuello.portfolio.entitys.Projects;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository <Projects, Long>{
    
}
