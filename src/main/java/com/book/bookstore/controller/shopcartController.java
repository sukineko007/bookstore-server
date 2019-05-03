package com.book.bookstore.controller;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.service.BookService;
import com.book.bookstore.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/shopcart")
public class shopcartController {

    @Autowired
    private ShopcartService shopcartService;
    @Autowired
    private BookService bookService;

    @PostMapping("/addShopcart")
    public ResponseBody addShopcart(BaseRequest request){
        shopcartService.addShopcart(request);
        return new ResponseBody();
    }

    @GetMapping("/getShopcart")
    public Object getShopcart(Integer userId){
        Map<String ,Object> map = new HashMap<>();
        map.put("data",shopcartService.getShopcart(userId));
        return map;
    }
    @PostMapping("/delShopcart")
    public ResponseBody delShopcart(Integer id){
        shopcartService.delShopcart(id);
        return new ResponseBody();
    }
    @PostMapping("/bachDelShopcart")
    public ResponseBody bachDel(String data){
        data = data.substring(0, data.length()-1);
        shopcartService.batchDelete(data);
        return new ResponseBody();
    }
}
