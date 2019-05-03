package com.book.bookstore.controller;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class categoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategory")
    public Object getCategory(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",categoryService.getCategory());
        return map;
    }
    @PostMapping("/updateCategory")
    public ResponseBody updateCategory(UpdateRequest request){
        categoryService.updateCategory(request);
        return new ResponseBody();
    }
    @PostMapping("/addCategory")
    public ResponseBody addCategory(BaseRequest request){
        categoryService.addCategory(request);
        return new ResponseBody();
    }
    @GetMapping("/searchCategory")
    public Object searchSingers(String catename){
        Map<String,Object> map = new HashMap<>();
        map.put("data",categoryService.searchCategory(catename));
        return map;
    }
    @PostMapping("/delCategory")
    public void delCategory(Integer id){
        categoryService.delCategory(id);
    }
}
