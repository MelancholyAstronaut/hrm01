package ch4;

import static org.junit.Assert.assertTrue;
import static sun.net.ftp.FtpReplyCode.find;

import Dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import po.teacher;
import utils.getSession;

import java.util.List;

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
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        System.out.println(teacherDao.find(1));


    }
}
