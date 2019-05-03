package com.book.bookstore.service;

import com.book.bookstore.beans.Address;
import com.book.bookstore.beans.User;
import com.book.bookstore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    public List getPerson(Integer userId){
        List<User> users = userMapper.selectById(userId);
        List<Map> mapList = new ArrayList<>();
        for(User user : users){
            Map map = new HashMap();
            map.put("id",user.getId());
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());
            map.put("nickname",user.getNickname());
            if(Integer.parseInt(user.getQq()) == 1){
                map.put("qq","消费者用户");
            }
            else{
                map.put("qq","管理员");
            }

            map.put("phone",user.getPhone());
            mapList.add(map);
        }
        return mapList;
    }
    public List searchUser(String data){
        List<User> users = userMapper.selectByName(data);
        List<Map> mapList = new ArrayList<>();
        for(User user : users){
            Map map = new HashMap();
            map.put("id",user.getId());
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());
            map.put("nickname",user.getNickname());
            if(Integer.parseInt(user.getQq()) == 1){
                map.put("qq","消费者用户");
            }
            else{
                map.put("qq","管理员");
            }
            map.put("phone",user.getPhone());
            mapList.add(map);
        }
        return mapList;
    }
    public List getUsers(){
        List<User> users = userMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for(User user : users){
            Map map = new HashMap();
            map.put("id",user.getId());
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());
            map.put("nickname",user.getNickname());
            if(Integer.parseInt(user.getQq()) == 1){
                map.put("qq","消费者用户");
            }
            else{
                map.put("qq","管理员");
            }
            map.put("phone",user.getPhone());
            mapList.add(map);
        }
        return mapList;
    }
    public void delUser(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }
    public void addUser(User request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setNickname(request.getNickname());
        user.setQq(request.getQq());
        user.setPhone(request.getPhone());
        userMapper.insertSelective(user);
    }
    public void updateUser(User request){
        User user = userMapper.selectByPrimaryKey(request.getId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setNickname(request.getNickname());
        user.setQq(request.getQq());
        user.setPhone(request.getPhone());
        userMapper.updateByPrimaryKeySelective(user);
    }
}
