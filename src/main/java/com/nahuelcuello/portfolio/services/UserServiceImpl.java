package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    // UPDATE
    @Override
    @Transactional
    public User update(Long id, User user) {
        User existingUser = findById(id);

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUrlImg(user.getUrlImg());

        return userRepository.save(existingUser);
    }

    // READ
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
     @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // DELETE
    @Override
     @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

     // CHANGE PASSWORD
    @Override
    @Transactional
    public void changePassword(Long id, String oldPassword, String newPassword) {
        User user = findById(id);
        
        if (!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("El password actual es incorrecto");
        }
        
        if (oldPassword.equals(newPassword)) {
            throw new RuntimeException("El nuevo password debe ser diferente al actual");
        }

        if (newPassword.length() < 8) {
            throw new RuntimeException("El nuevo password debe tener al menos 8 caracteres");
        }

        user.setPassword(newPassword);
        userRepository.save(user);
    }

}
