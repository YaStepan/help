package ru.springboot.pp312.dao;

import org.springframework.stereotype.Repository;
import ru.springboot.pp312.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
