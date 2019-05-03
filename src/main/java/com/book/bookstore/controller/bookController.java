package com.book.bookstore.controller;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getCategoryBook")
    public Object getCategoryBook(Integer categoryId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookService.getCategoryBook(categoryId));
        return map;
    }

    @PostMapping("/delBook")
    public ResponseBody delBook(Integer id){
        bookService.delBook(id);
        return new ResponseBody();
    }
    @PostMapping("/addBook")
    public ResponseBody addBook(BaseRequest request){
        bookService.addBook(request);
        return new ResponseBody();
    }
    @GetMapping("/searchBook")
    public Object searchBook(String name,Integer categoryId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookService.searchBook(name,categoryId));
        return map;
    }
}
