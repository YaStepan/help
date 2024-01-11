package ru.springboot.pp312.dao;

import ru.springboot.pp312.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
