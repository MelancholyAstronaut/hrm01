package com.abc.dao;

import com.abc.pojo.Newslabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface INewsManagerDao {
    List<Newslabel> checkAllLable(); //查询所有
    int checkCount();
    @Delete("delete from newlabel where id = #{id}") //根据id'删除一个
    void deleteOne(int id);
    Newslabel queryById(int id); //根据id查询一个
    @Select("select ID from newlabel where label_name=#{name}")
    int queryIdByName(String name);//根据名字查询
    void update(Newslabel newslabel);
    List<Newslabel> checkAllParentLable();
    @Select("select count(ID) from newlabel where pid =#{id}")
    int queryCountChlidByParentId(int id);
    List<Newslabel> queryAllChlidByParentId(@Param("id") int id);
    void addLabel(Newslabel newslabel);
    @Select("select pid from newlabel where ID =#{id}")
    int queryPidById(int id);

    Integer login(@Param("name") String name, @Param("pwd") String pwd);
}
