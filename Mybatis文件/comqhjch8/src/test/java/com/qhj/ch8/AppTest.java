package com.qhj.ch8;

import com.qhj.ch8.Dao.StudentDao;
import com.qhj.ch8.po.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest<pvt>
{
    SqlSession sqlSession = null;
    /**
     * Rigorous Test :-)
     */
    @Before
    public void setUp() throws Exception{
        //获取sqlsession
        InputStream in = Resources.getResourceAsStream("myBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void test01()
    {
        StudentDao stu = sqlSession.getMapper(StudentDao.class);
        stu.findAll().forEach(e-> System.out.println(e));
    }
    @Test
    public void test02(){
        StudentDao stu = sqlSession.getMapper(StudentDao.class);
        user u = stu.findUserById(1);
        System.out.println(u);
    }
    @Test
    public void Test03(){
        StudentDao stu = sqlSession.getMapper(StudentDao.class);
        stu.insertUser(new user("小李"));
    }
    @Test
    public void Test04(){
        StudentDao stu = sqlSession.getMapper(StudentDao.class);
        stu.deleteUser(1);
    }
    @Test
    public void Test05(){
        StudentDao stu = sqlSession.getMapper(StudentDao.class);
        user user = new user(2,"小芳");
        stu.updateUser(user);
    }
    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
