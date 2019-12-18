package com.abc.dao;

import com.abc.pojo.Newslabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface INewsManagerDao {
    List<Newslabel> checkAllLable(int pages); //查询所有
    int checkCount();
    @Delete("delete from newlabel where id = #{id}") //根据id'删除一个
    void deleteOne(int id);
    Newslabel queryById(int id); //根据id查询一个
    @Select("select ID from newlabel where label_name=#{name}")
    int queryIdByName(String name);//根据名字查询
    void update(Map<String, Object> map);
    @Select("SELECT * FROM newlabel WHERE pid is null")
    List<Newslabel> checkAllParentLable();
    @Select("select count(ID) from newlabel where pid =#{id}")
    int queryCountChlidByParentId(int id);

    List<Newslabel> queryAllChlidByParentId(@Param("id") int id, @Param("pages") int pages);

    void addLabel(Newslabel newslabel);
}
