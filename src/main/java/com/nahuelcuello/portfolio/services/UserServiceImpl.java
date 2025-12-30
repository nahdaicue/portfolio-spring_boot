package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.repositorys.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    // UPDATE
    @Override
    public User update(Long id, User user) {
        User existingUser = findById(id);

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    // READ
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // DELETE
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
