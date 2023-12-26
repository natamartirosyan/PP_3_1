package org.natamartirosyan.springboot.PP_3_1.dao;

import org.natamartirosyan.springboot.PP_3_1.model.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);

    User findUser(int id);

    void editUserById (User user);

    void removeUserById(int id);

    List<User> getAllUsers();

}
