package com.mp.simple;

import com.mp.simple.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    @Test
//    testFindAll
    public void test1() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(configFile);
        SqlSessionFactory sessionFactory =new  SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        um.findAll().forEach(e-> System.out.println(e));



    }
}
