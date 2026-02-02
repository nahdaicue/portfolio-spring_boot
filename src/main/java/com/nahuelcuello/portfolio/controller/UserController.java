package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET ALL
    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    // CREATE
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User user
    ) {
        return userService.update(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
