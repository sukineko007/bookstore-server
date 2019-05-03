package com.book.bookstore.service;

import com.book.bookstore.beans.User;
import com.book.bookstore.mapper.UserMapper;
import com.book.bookstore.serviceImpl.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginImpl {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkLogin(String username,String password){
        User user = userMapper.checkLogin(username, password);
        return user;
    }
}
