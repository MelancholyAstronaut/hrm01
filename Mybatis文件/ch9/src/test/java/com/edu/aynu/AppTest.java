package com.edu.aynu;

import static org.junit.Assert.assertTrue;

import com.edu.aynu.Dao.userDao;
import com.edu.aynu.po.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    SqlSession sqlSession = null;
    @Before
    public void setUp() throws Exception{  //预备好我的sqlsession
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("myBatis.xml")).openSession();
    }
    @Test
    public void Test01(){
        userDao ud  = sqlSession.getMapper(userDao.class);
        List<user> lu = ud.findAll();
        for(user u:lu){
            System.out.println(u);
       //     System.out.println(u.getBook());
        }


    }
}
