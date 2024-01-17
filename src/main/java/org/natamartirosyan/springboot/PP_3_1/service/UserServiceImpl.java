package org.natamartirosyan.springboot.PP_3_1.service;

import org.natamartirosyan.springboot.PP_3_1.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.natamartirosyan.springboot.PP_3_1.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User findUser(int id) {
        return userDAO.findUser(id);
    }

    @Override
    public void editUserById(User user) {
        userDAO.editUserById(user);
    }

    @Override
    public void removeUserById(int id) {
        userDAO.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
