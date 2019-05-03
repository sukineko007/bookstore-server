package com.book.bookstore.controller;

import com.book.bookstore.beans.BookMessage;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.service.BookMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class bookMessageController {

    @Autowired
    private BookMessageService bookMessageService;

    @GetMapping("/getMessage")
    public Object getMessage(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookMessageService.getMessage());
        return map;
    }
    @PostMapping("/addMessage")
    public ResponseBody addMessage(BookMessage request){
        bookMessageService.addMessage(request);
        return new ResponseBody();
    }
    @PostMapping("delMessage")
    public void delMessage(Integer id){
        bookMessageService.delMessage(id);
    }
}
