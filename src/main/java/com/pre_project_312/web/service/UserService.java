package com.pre_project_312.web.service;

import com.pre_project_312.web.entity.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    void removeUserById(Integer userId);

    User getUserById(Integer userId);

    void updateUser(User user);
}