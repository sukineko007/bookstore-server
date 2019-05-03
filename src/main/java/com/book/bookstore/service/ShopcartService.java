package com.book.bookstore.service;

import com.book.bookstore.beans.Address;
import com.book.bookstore.beans.Shopcart;
import com.book.bookstore.mapper.ShopcartMapper;
import com.book.bookstore.module.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private BookService bookService;

    public void addShopcart(BaseRequest request){
        Shopcart shopcart = new Shopcart();
        shopcart.setBookId(request.getBookId());
        shopcart.setUserId(request.getUserId());
        shopcart.setAddTime(request.getAddTime());
        shopcart.setBookNum(request.getBookNum());
        shopcartMapper.insert(shopcart);
    }
    public void delShopcart(Integer id){
        shopcartMapper.deleteByPrimaryKey(id);
    }
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            shopcartMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    public int getNumByBookID(Integer bookId){
        return shopcartMapper.getNum(bookId);
    }
    public List getShopcart(Integer userId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        List<Shopcart> shopcarts= shopcartMapper.selectByUserId(userId);
        List<Map> mapList = new ArrayList<>();
        for(Shopcart shopcart : shopcarts){
            Map map = new HashMap();
            map.put("id",shopcart.getId());
            map.put("bookname",bookService.getBookById(shopcart.getBookId()).getName());
            map.put("book_num",shopcart.getBookNum());
            map.put("price",bookService.getBookById(shopcart.getBookId()).getPrice());
            map.put("add_time",df.format(shopcart.getAddTime()));
            mapList.add(map);
        }
        return mapList;
    }
}
