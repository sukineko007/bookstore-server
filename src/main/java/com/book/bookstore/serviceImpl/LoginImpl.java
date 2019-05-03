package com.book.bookstore.serviceImpl;

import com.book.bookstore.beans.User;

public interface LoginImpl {

    User checkLogin(String username,String password);
}
