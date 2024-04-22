package org.example.Task4.dao;

import org.example.Task4.model.UserEntitry;

import java.util.List;

public interface UserDao  {
    UserEntitry save(UserEntitry user);

    void delete(Long id);

    UserEntitry findById(Long id);

    List<UserEntitry> findAll();
}
