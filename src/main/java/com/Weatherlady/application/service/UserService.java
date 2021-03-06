package com.Weatherlady.application.service;

import com.Weatherlady.HibernateUtils;
import com.Weatherlady.application.entity.User;
import com.Weatherlady.application.repository.user.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class UserService {

    private final HibernateUtils hibernateUtils = new HibernateUtils();
    private final EntityManager entityManager = hibernateUtils.getSessionFactory().createEntityManager();
    private final UserRepository userRepository = new UserRepository(entityManager);

    public User registerUser (String userName, String password) {
        List<User> userList = userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                System.out.println("User name " + userName + " already exist.");
                return null;
            }
        }
                User user = new User(userName, password);
                userRepository.save(user);
                return user;
    }

    public boolean loginUser(String userName, String password) {
        List<User> userList = userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName) && userList.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }



}
