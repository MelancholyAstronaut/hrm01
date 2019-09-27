package ch4;

import static org.junit.Assert.assertTrue;

import Dao.husbandDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import po.husband;
import utils.getSession;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test01()throws  Exception{
        SqlSession sqlSession = getSession.getSqlSession();
        husbandDao hus = sqlSession.getMapper(husbandDao.class);
        husband h = hus.find(1);
        husband h1 = hus.find(2);
        husband h2 = hus.find(3);
        System.out.println(h);
        System.out.println(h1);
        System.out.println(h2);

    }
}
