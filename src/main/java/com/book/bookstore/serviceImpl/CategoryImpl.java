package com.book.bookstore.serviceImpl;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;

import java.util.List;

public interface CategoryImpl {

    List getCategory();
    void updateCategory(UpdateRequest request);
    void addCategory(BaseRequest request);
    List searchCategory(String catename);
}
