package ch6;

import static org.junit.Assert.assertTrue;

import ch6.dao.userDao;
import ch6.po.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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
    public void setUp() throws Exception{
        String url = "myBatis.xml";
        InputStream ip  = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ip);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void Test01(){
        userDao ud = sqlSession.getMapper(userDao.class);
        List<user> userList = ud.findAll();
//        for(user u:userList){
//            System.out.println(u);
//            System.out.println(u.getBook());
//        }
    }
}
