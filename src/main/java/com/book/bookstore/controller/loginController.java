package com.book.bookstore.controller;

import com.book.bookstore.beans.User;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public User checkLogin(String username, String password){
        User user = loginService.checkLogin(username, password);
        return user;
    }

    @PostMapping("/register")
    public ResponseBody register(BaseRequest request){
        return new ResponseBody();
    }
}
