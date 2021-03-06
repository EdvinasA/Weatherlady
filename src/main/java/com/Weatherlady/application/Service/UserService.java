package com.Weatherlady.application.Service;

import com.Weatherlady.HibernateUtils;
import com.Weatherlady.application.Entity.User;
import com.Weatherlady.application.Repository.User.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class UserService {

    private final HibernateUtils hibernateUtils = new HibernateUtils();
    private final EntityManager entityManager = hibernateUtils.getSessionFactory().createEntityManager();
    private final UserRepository userRepository = new UserRepository(entityManager);

    public void registerUser (String userName, String password) {
        List<User> userList = userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                System.out.println("User name " + userName + " already exist.");
                return;
            }
        }
                User user = new User(userName, password);
                userRepository.save(user);
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
