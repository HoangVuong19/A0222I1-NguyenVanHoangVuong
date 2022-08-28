package com.example.user.service;

import com.example.user.config.Validation;
import com.example.user.repository.IUserRepository;
import com.example.user.repository.UserRepository;
import com.example.user.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> findAllUsers() {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public Map<String, String> addUser(User user) {
        Map<String, String> map = new HashMap<>();
        if(!Validation.checkEmail(user.getEmail())){
            map.put("email","email is error");
        }
        if (user.getName().equals("")){
            map.put("name", "name is not null");
        }
        if (user.getEmail().equals("")){
            map.put("email", "email is not null");
        }
        if (user.getCountry().equals("")){
            map.put("country", "country is not null");
        }
        if (map.isEmpty()){
            iUserRepository.insertUser(user);
        }
        return map;
    }

    @Override
    public User findUserById(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return iUserRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return iUserRepository.deleteUser(id);
    }

    @Override
    public List<User> searchByName(String character) {
        return iUserRepository.searchUser(character);
    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortUser();
    }
}
