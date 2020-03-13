package com.mp.simple;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.mp.simple.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatisPlus {
    @Test
//    testFindAll
    public void test1() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(configFile);
        SqlSessionFactory sessionFactory =new MybatisSqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        um.selectList(null).forEach(e-> System.out.println(e));



    }
}
