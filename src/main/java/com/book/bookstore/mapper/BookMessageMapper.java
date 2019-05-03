package com.book.bookstore.mapper;

import com.book.bookstore.beans.BookMessage;
import com.book.bookstore.beans.BookMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMessageMapper {
    int countByExample(BookMessageExample example);

    int deleteByExample(BookMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookMessage record);

    int insertSelective(BookMessage record);

    List<BookMessage> selectByExample(BookMessageExample example);

    BookMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookMessage record, @Param("example") BookMessageExample example);

    int updateByExample(@Param("record") BookMessage record, @Param("example") BookMessageExample example);

    int updateByPrimaryKeySelective(BookMessage record);

    int updateByPrimaryKey(BookMessage record);

    List<BookMessage> selectAll();
}