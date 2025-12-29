
package com.nahuelcuello.portfolio.repositorys;

import com.nahuelcuello.portfolio.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    
}
