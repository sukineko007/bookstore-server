package com.book.bookstore.controller;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.ResponseBody;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class addressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getSelectAddress")
    public Object getSelectAddress(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",addressService.getSelectAddress(userId));
        return map;
    }
    @GetMapping("/getAddress")
    public Object getAddress(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",addressService.getAddress(userId));
        return map;
    }
    @PostMapping("/addAddress")
    public ResponseBody addAddress(BaseRequest request){
        addressService.addAddress(request);
        return new ResponseBody();
    }
    @PostMapping("/delAddress")
    public ResponseBody delAddress(Integer id){
        addressService.delAddress(id);
        return new ResponseBody();
    }
    @PostMapping("/updateAddress")
    public ResponseBody updateAddress(UpdateRequest request){
        addressService.updateAddress(request);
        return new ResponseBody();
    }
}
