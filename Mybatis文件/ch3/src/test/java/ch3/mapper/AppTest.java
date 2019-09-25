package ch3.mapper;

import static org.junit.Assert.assertTrue;

import Dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import po.Student;
import utils.SqlsessionBulid;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void findAllTest01() throws Exception {
        StudentDao s1 = SqlsessionBulid.SqlsessionBulid().getMapper(StudentDao.class);
        s1.FindAll().forEach(e -> System.out.println(e));
    }

    @Test
    public void findId() throws Exception {
        StudentDao s1 = SqlsessionBulid.SqlsessionBulid().getMapper(StudentDao.class);
        int[] arr = {1, 2, 3, 4, 5, 6};
        s1.findId(arr).forEach(e -> System.out.println(e)); //动态sql
    }

    @Test
    public void findName() throws Exception {
        StudentDao s1 = SqlsessionBulid.SqlsessionBulid().getMapper(StudentDao.class);
        String s = "小";
        s1.findName(s).forEach(e -> System.out.println(e));
    }

    @Test
    public void findByCondition() throws Exception {
        StudentDao s1 = SqlsessionBulid.SqlsessionBulid().getMapper(StudentDao.class);
        Map<String, String> map = new HashMap<>();
        //map.put("name","小");
        map.put("age", "1");
        s1.findByCondition(map).forEach(e -> System.out.println(e));
    }

    //插入一个并且返回id
    @Test
    public void InsertAfterReturnId() throws Exception {
        SqlSession sqlSession = SqlsessionBulid.SqlsessionBulid();
        StudentDao s1 = sqlSession.getMapper(StudentDao.class);
        Map<String, Student> map = new HashMap<>();
        Student student = new Student("小黑", 20, 98);
        map.put("time", new Student("小黑", 20, 98));
        map.put("time1", new Student("小黑", 21, 98));
        map.put("time2", new Student("小黑", 22, 98));
        int t = s1.InsertAfterReturnId(map);
        System.out.println(t);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteDuplicateData() throws Exception {
        SqlSession sqlSession = SqlsessionBulid.SqlsessionBulid();
        StudentDao s1 = sqlSession.getMapper(StudentDao.class);
        s1.deleteDuplicateData();
        sqlSession.commit();
        sqlSession.close();
    }
}
