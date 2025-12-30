
package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.User;
import java.util.List;

public interface UserService {
    
    User save(User user);

    User update(Long id, User user);

    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);
    
}
