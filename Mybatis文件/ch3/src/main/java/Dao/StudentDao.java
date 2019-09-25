package Dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> FindAll() throws Exception;

    List<Student> findId(@Param("arr") int[] arr) throws Exception;

    List<Student> findName(String name);

    List<Student> findByCondition(Map map);
    int  InsertAfterReturnId(@Param("userMap") Map map); //如果这里写返回值,则返回值就是插入了几条记录
    void deleteDuplicateData();
}
