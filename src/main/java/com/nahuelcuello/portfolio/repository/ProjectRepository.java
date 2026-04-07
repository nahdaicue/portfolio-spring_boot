
package com.nahuelcuello.portfolio.repository;

import com.nahuelcuello.portfolio.entitys.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long>{
    
}
