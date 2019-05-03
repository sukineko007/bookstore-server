package com.book.bookstore.service;

import com.book.bookstore.beans.Book;
import com.book.bookstore.beans.BookMessage;
import com.book.bookstore.mapper.BookMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookMessageService {

    @Autowired
    private BookMessageMapper bookMessageMapper;

    public List getMessage(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        List<BookMessage> bookMessages = bookMessageMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for(BookMessage bookMessage : bookMessages){
            Map map = new HashMap();
            map.put("id",bookMessage.getId());
            map.put("updateContent",bookMessage.getUpdateContent());
            map.put("updateTime",df.format(bookMessage.getUpdateTime()));
            mapList.add(map);
        }
        return mapList;
    }
    public void addMessage(BookMessage request){
        BookMessage bookMessage = new BookMessage();
        bookMessage.setUpdateContent(request.getUpdateContent());
        bookMessageMapper.insertSelective(bookMessage);
    }
    public void delMessage(Integer id){
        bookMessageMapper.deleteByPrimaryKey(id);
    }
}
