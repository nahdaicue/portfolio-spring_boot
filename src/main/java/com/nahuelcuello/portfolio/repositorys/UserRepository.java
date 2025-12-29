
package com.nahuelcuello.portfolio.repositorys;

import com.nahuelcuello.portfolio.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    
    
    
}
