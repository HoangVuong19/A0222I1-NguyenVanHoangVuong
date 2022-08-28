package com.example.user.service;

import com.example.user.model.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAllUsers();

    Map<String, String> addUser(User user);

    User findUserById(int id);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
