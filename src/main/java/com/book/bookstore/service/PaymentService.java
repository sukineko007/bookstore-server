package com.book.bookstore.service;

import com.book.bookstore.beans.Payment;
import com.book.bookstore.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public Payment getPay(Integer id){
        return paymentMapper.selectByPrimaryKey(id);
    }
}
