package com.story.service;

import com.story.entity.User;

import java.util.Optional;

public interface UserService {

    User addUser(User user);
    Optional<User> getUserById(Long id);
}
