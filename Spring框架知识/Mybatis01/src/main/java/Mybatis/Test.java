package Mybatis;

import com.mybatis.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Administrator
 */

public class Test {


    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student student = new Student("麻子", 99.5);
        SqlSessionFactory ssf  = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss =ssf.openSession(true);

        for (int i=0;i<5;i++) {
            ss.insert("InsertOne",student);
        }
        System.out.println("插入结束");
        ss.close();
    }
}
