package com.edu.aynu.Dao;

import com.edu.aynu.po.user;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface userDao {
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(property = "book", column = "id"
           , one = @One(select = "com.edu.aynu.Dao.bookDao.findBookById", fetchType = FetchType.DEFAULT
            ))
    })
    List<user> findAll();

}
