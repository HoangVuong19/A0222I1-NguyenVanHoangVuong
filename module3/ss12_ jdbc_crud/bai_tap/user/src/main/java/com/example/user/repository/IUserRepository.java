package com.example.user.repository;

import com.example.user.model.User;
import java.util.List;

public interface IUserRepository {
    List<User> selectAllUsers();

    void insertUser(User user);

    User selectUser(int id);

    boolean updateUser(User user);

    boolean deleteUser(int id);


}
