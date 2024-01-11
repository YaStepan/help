package ru.springboot.pp312.service;


import ru.springboot.pp312.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
