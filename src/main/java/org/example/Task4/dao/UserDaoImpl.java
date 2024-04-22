package org.example.Task4.dao;

import org.example.Task4.model.UserEntitry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntitry save(UserEntitry user) {
//        entityManager.persist(user);
        return user;
    }

    @Override
    public void delete(Long id) {
//        UserEntitry user = entityManager.find(UserEntitry.class, id);
//        entityManager.remove(user);
    }

    @Override
    public UserEntitry findById(Long id) {
//        return entityManager.find(UserEntitry.class, id);
        return new UserEntitry();
    }

    @Override
    public List<UserEntitry> findAll() {
//        return entityManager.createQuery("SELECT u FROM User u", UserEntitry.class).getResultList();
        return null;
    }
}
