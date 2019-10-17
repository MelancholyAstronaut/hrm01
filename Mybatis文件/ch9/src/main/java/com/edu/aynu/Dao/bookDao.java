package com.edu.aynu.Dao;

import com.edu.aynu.po.book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bookDao {
    @Select("select * from book where book.user_id=#{value}")
    book findBookById(Integer id);
}
