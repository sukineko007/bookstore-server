package com.book.bookstore.serviceImpl;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;

import java.util.List;

public interface BookImpl {

    List getCategoryBook(Integer categoryId);

    void delBook(Integer id);

    void addBook(BaseRequest request);

    void updateBook(UpdateRequest request);
}
