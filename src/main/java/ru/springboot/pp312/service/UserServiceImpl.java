package ru.springboot.pp312.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springboot.pp312.dao.UserDao;
import ru.springboot.pp312.entity.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User getUser(int id) {
        return userDao.getUser(id);
    }

}