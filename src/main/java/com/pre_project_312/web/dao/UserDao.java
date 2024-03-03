package com.pre_project_312.web.dao;



import com.pre_project_312.web.entity.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);

   List<User> getAllUsers();

   void removeUserById(Integer userId);

   User getUserById(Integer userId);

   void updateUser(User user);
}
