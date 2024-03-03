package com.pre_project_312.web.dao;

import com.pre_project_312.web.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> getAllUsers() {
      return entityManager.createQuery("FROM User", User.class).getResultList();
   }

   @Override
   public void removeUserById(Integer userId) {
      User user = entityManager.find(User.class, userId);
      entityManager.remove(user);
   }

   @Override
   public User getUserById(Integer userId) {
      return entityManager.find(User.class, userId);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }
}
