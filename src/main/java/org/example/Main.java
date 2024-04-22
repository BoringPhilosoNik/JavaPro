package org.example;

import org.example.Task4.config.DataSourceConfig;
import org.example.Task4.dao.UserDaoImpl;
import org.example.Task4.model.UserEntitry;
import org.example.Task4.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, UserDaoImpl.class, UserService.class);

        UserService userService = context.getBean(UserService.class);

        UserEntitry user1 = new UserEntitry();
        user1.setUsername("user1");
        userService.create(user1);

        userService.delete(user1.getId());

        UserEntitry user2 = userService.getById(1L);

        List<UserEntitry> users = userService.getAll();

        for (UserEntitry user : users) {
            System.out.println(user);
        }

    }
}