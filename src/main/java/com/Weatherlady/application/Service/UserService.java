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
            if (userName.length() < 5 && findUser(userName).getUserName().equals(userName)) {
                System.out.println("Name too short or user name already exist.");
            } else {
                User user = new User(userName, password);
                userRepository.save(user);
            }
    }

    public boolean loginUser(String userName, String password) {
            if (findUser(userName).getUserName().equals(userName) && findUser(userName).getPassword().equals(password)) {
                System.out.println("You signed in.");
                return true;
            } else{
                System.out.println("Try signing in again.");
                System.out.println("Or register new user.");
                return false;
            }
    }

    public User findUser (String userName) {
        List<User> users = userRepository.findWithName(userName);
        return users.get(0);
    }

}
