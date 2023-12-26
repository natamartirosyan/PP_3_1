package org.natamartirosyan.springboot.PP_3_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.natamartirosyan.springboot.PP_3_1.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }
    @Transactional
    @Override
    public User findUser(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void editUserById(User user) {
        em.merge(user);
    }

    @Transactional
    public void removeUserById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }
}
