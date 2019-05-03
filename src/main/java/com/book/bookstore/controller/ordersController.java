package com.book.bookstore.controller;

import com.book.bookstore.beans.Orders;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class ordersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/addOrder")
    public ResponseBody addOrder(BaseRequest request){
        ordersService.addOrder(request);
        return new ResponseBody();
    }
    @GetMapping("/getMyOrder")
    public Object getMyOrder(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",ordersService.getMyOrder(userId));
        return map;
    }
    @PostMapping("/delOrder")
    public ResponseBody delOrder(BaseRequest request){
        ordersService.delOrder(request.getId());
        return new ResponseBody();
    }
    @GetMapping("/searchOrder")
    public Object searchOrder(Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",ordersService.searchOrder(id));
        return map;
    }
    @PostMapping("/cancelOrder")
    public ResponseBody cancelOrder(UpdateRequest request){
        return new ResponseBody();
    }
    @PostMapping("/payOrder")
    public ResponseBody payOrder(Orders request){
        ordersService.payOrder(request);
        return new ResponseBody();
    }
    @GetMapping("/getOrders")
    public Object getOrders(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",ordersService.getOrders());
        return map;
    }
}
