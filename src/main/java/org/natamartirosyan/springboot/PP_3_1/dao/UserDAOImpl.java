package org.natamartirosyan.springboot.PP_3_1.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.natamartirosyan.springboot.PP_3_1.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUserById(User user) {
        em.merge(user);
    }

    @Override
    public void removeUserById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }
}
