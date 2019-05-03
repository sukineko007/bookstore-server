package com.book.bookstore.service;

import com.book.bookstore.beans.Orders;
import com.book.bookstore.mapper.OrdersMapper;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Autowired
    private OrdersMapper orderMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentService paymentService;

    public void addOrder(BaseRequest request){
        Orders orders = new Orders();
        orders.setUserId(request.getUserId());
        orders.setTotalPrice(request.getTotalPrice());
        orders.setCreateTime(request.getCreateTime());
        orders.setAddressId(request.getAddressId());
        orderMapper.insert(orders);
    }
    public List getMyOrder(Integer userId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        List<Orders> orders = orderMapper.selectByUserId(userId);
        List<Map> mapList = new ArrayList<>();
        for(Orders orders1 : orders){
            Map map = new HashMap();
            map.put("order_num",orders1.getOrderNum());
            map.put("username",userService.getUser(orders1.getUserId()).getUsername());
            map.put("totalPrice",orders1.getTotalPrice());
            map.put("address",addressService.getAddress2(orders1.getAddressId()).getProvince()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCity()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCounty()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getJuti());
            if(orders1.getState() == 0){
                map.put("state","待支付");
            }
            else if(orders1.getState() == 1){
                map.put("state","已支付");
            }
            else
            map.put("state","已取消");
            map.put("createTime",df.format(orders1.getCreateTime()));
            if(orders1.getPaymentId() == null){
                map.put("payment","");
            }
            else
            map.put("payment",paymentService.getPay(orders1.getPaymentId()).getPayName());
            if(orders1.getPayTime() == null){
                map.put("payTime","");
            }
            else
            map.put("payTime",df.format(orders1.getPayTime()));
            mapList.add(map);
        }
        return mapList;

    }
    public void delOrder(Integer id){
        orderMapper.deleteByPrimaryKey(id);
    }
    public  List searchOrder(Integer id){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        List<Orders> orders = orderMapper.selectByPrimaryKey(id);
        List<Map> mapList = new ArrayList<>();
        for(Orders orders1 : orders){
            Map map = new HashMap();
            map.put("order_num",orders1.getOrderNum());
            map.put("username",userService.getUser(orders1.getUserId()).getUsername());
            map.put("totalPrice",orders1.getTotalPrice());
            map.put("address",addressService.getAddress2(orders1.getAddressId()).getProvince()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCity()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCounty()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getJuti());
            if(orders1.getState() == 0){
                map.put("state","待支付");
            }
            else if(orders1.getState() == 1){
                map.put("state","已支付");
            }
            else
                map.put("state","已取消");
            map.put("createTime",df.format(orders1.getCreateTime()));
            map.put("payment",orders1.getPaymentId());
            map.put("payTime",orders1.getPayTime());
            mapList.add(map);
        }
        return mapList;
    }
    public List getOrders(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        List<Orders> orders = orderMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for(Orders orders1 : orders){
            Map map = new HashMap();
            map.put("order_num",orders1.getOrderNum());
            map.put("username",userService.getUser(orders1.getUserId()).getUsername());
            map.put("totalPrice",orders1.getTotalPrice());
            map.put("address",addressService.getAddress2(orders1.getAddressId()).getProvince()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCity()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getCounty()+"/"+
                    addressService.getAddress2(orders1.getAddressId()).getJuti());
            if(orders1.getState() == 0){
                map.put("state","待支付");
            }
            else if(orders1.getState() == 1){
                map.put("state","已支付");
            }
            else
                map.put("state","已取消");
            map.put("createTime",df.format(orders1.getCreateTime()));
            if(orders1.getPaymentId() == null){
                map.put("payment","");
            }
            else
            map.put("payment",paymentService.getPay(orders1.getPaymentId()).getPayName());
            if(orders1.getPayTime() == null){
                map.put("payTime","");
            }
            else
            map.put("payTime",df.format(orders1.getPayTime()));
            mapList.add(map);
        }
        return mapList;

    }
    public void payOrder(Orders request){
       Orders orders = orderMapper.selectById(request.getOrderNum());
       orders.setPaymentId(request.getPaymentId());
       orders.setPayTime(request.getPayTime());
       orders.setState(1);
       orderMapper.updateByPrimaryKeySelective(orders);
    }
}
