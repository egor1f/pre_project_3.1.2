package com.pre_project_312.web.service;

import com.pre_project_312.web.dao.UserDao;
import com.pre_project_312.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {}

    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void removeUserById(Integer userId) {
        userDao.removeUserById(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
