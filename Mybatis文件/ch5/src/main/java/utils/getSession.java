package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class
getSession {
    public static  SqlSession getSqlSession() throws  Exception{
        String url = "config/myBaties.xml";
        InputStream ip  = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ip);
        return sqlSessionFactory.openSession();
    }
}
