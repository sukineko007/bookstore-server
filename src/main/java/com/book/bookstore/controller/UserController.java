package com.book.bookstore.controller;

import com.book.bookstore.beans.User;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getPerson")
    public Object getPerson(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userService.getPerson(userId));
        return map;
    }
    @GetMapping("/getUsers")
    public Object getUsers(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userService.getUsers());
        return map;
    }
    @PostMapping("/delUser")
    public void delUser(Integer id){
        userService.delUser(id);
    }
    @GetMapping("/searchUser")
    public Object searchUser(String data){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userService.searchUser(data));
        return map;
    }
    @PostMapping("/addUser")
    public com.book.bookstore.module.ResponseBody addBook(User request){
        userService.addUser(request);
        return new ResponseBody();
    }
    @PostMapping("/updateUser")
    public com.book.bookstore.module.ResponseBody updateBook(User request){
        userService.updateUser(request);
        return new ResponseBody();
    }
}
