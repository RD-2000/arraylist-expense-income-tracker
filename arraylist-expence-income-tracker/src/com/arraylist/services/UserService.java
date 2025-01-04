package com.arraylist.services;

import com.arraylist.model.User;

import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();
    private int nextId = 1;

    public User registerUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists!");
                return null;
            }
        }
        User user = new User(nextId++, username, password);
        users.add(user);
        return user;
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}


