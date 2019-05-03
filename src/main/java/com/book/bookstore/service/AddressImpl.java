package com.book.bookstore.service;

import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AddressImpl {

    List getAddress(Integer userId);

    void addAddress(BaseRequest request);

    void delAddress(Integer id);

    void updateAddress(UpdateRequest request);
}
