package org.example.Task4.service;

import org.example.Task4.dao.UserDao;
import org.example.Task4.model.UserEntitry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntitry create(UserEntitry user) {
        return userDao.save(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public UserEntitry getById(Long id) {
        return userDao.findById(id);
    }

    public List<UserEntitry> getAll() {
        return userDao.findAll();
    }
}
