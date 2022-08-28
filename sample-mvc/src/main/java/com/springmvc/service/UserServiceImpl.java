package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.UserDao;
import com.springmvc.model.Login;
import com.springmvc.model.User;

public class UserServiceImpl implements UserService {
    
    @Autowired
    public UserDao userDao;

    @Override
    public int register(User user) {
        return userDao.register(user);
    }

    @Override
    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }
}
