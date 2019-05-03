package com.book.bookstore.service;

import com.book.bookstore.beans.Book;
import com.book.bookstore.mapper.BookMapper;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.serviceImpl.BookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements BookImpl {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CategoryService categoryService;



    @Override
    public List getCategoryBook(Integer categoryId){
        List<Book> books = bookMapper.selectByCategory(categoryId);
        List<Map> mapList = new ArrayList<>();
        for(Book book : books){
            Map map = new HashMap();
            map.put("id",book.getId());
            map.put("author",book.getAuthor());
            map.put("category",categoryService.getCategoryById(book.getCategoryId()).getCatename());
            map.put("name",book.getName());
            map.put("img",book.getImg());
            map.put("price",book.getPrice());
            map.put("press",book.getPress());
            map.put("introduction",book.getIntroduction());
            mapList.add(map);
        }
        return mapList;
    }

    public List searchBook(String name,Integer categoryId){
        List<Book> books = bookMapper.searchBook(name,categoryId);
        List<Map> mapList = new ArrayList<>();
        for(Book book : books){
            Map map = new HashMap();
            map.put("id",book.getId());
            map.put("author",book.getAuthor());
            map.put("category",categoryService.getCategoryById(book.getCategoryId()).getCatename());
            map.put("name",book.getName());
            map.put("img",book.getImg());
            map.put("price",book.getPrice());
            map.put("press",book.getPress());
            map.put("introduction",book.getIntroduction());
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public void delBook(Integer id){
        bookMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void addBook(BaseRequest request){
        Book book = new Book();
        book.setImg(request.getImg());
        book.setAuthor(request.getAuthor());
        book.setCategoryId(request.getCategoryId());
        book.setIntroduction(request.getIntroduction());
        book.setName(request.getName());
        book.setPress(request.getPress());
        book.setPrice(request.getPrice());
        bookMapper.insert(book);
    }

    @Override
    public void updateBook(UpdateRequest request){
        Book book = bookMapper.selectByPrimaryKey(request.getId());
        book.setImg(request.getImg());
        book.setCategoryId(categoryService.selectCategoryIdByCatename(request.getCatename()));
        book.setAuthor(request.getAuthor());
        book.setIntroduction(request.getIntroduction());
        book.setName(request.getName());
        book.setPress(request.getPress());
        book.setPrice(request.getPrice());
        bookMapper.updateByPrimaryKeySelective(book);
    }
    public Book getBookById(Integer bookId){
        return bookMapper.selectByPrimaryKey(bookId);
    }
}
