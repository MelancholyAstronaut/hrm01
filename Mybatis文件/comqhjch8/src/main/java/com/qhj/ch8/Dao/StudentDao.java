package com.qhj.ch8.Dao;

import com.qhj.ch8.po.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {
    @Select("select * from users")
    public List<user> findAll();
    @Select("select * from users where id = #{value}")
    user findUserById(Integer id);
    @Update("insert into users (id,name) values(#{id},#{name})")
    void insertUser(user user);
    @Delete("delete from student where id=#{id}")
    void deleteUser(Integer id);
    @Update("update student set name=#{name} where id=#{id}")
    void updateUser(user user);
}
