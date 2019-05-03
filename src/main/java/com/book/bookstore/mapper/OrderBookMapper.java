package com.book.bookstore.mapper;

import com.book.bookstore.beans.OrderBook;
import com.book.bookstore.beans.OrderBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderBookMapper {
    int countByExample(OrderBookExample example);

    int deleteByExample(OrderBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderBook record);

    int insertSelective(OrderBook record);

    List<OrderBook> selectByExample(OrderBookExample example);

    OrderBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderBook record, @Param("example") OrderBookExample example);

    int updateByExample(@Param("record") OrderBook record, @Param("example") OrderBookExample example);

    int updateByPrimaryKeySelective(OrderBook record);

    int updateByPrimaryKey(OrderBook record);
}