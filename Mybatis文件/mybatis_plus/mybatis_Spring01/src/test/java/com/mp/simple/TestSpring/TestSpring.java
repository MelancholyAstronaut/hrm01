package com.mp.simple.TestSpring;

import com.mp.simple.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpring {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        this.userMapper.selectList(null).forEach(e-> System.out.println(e));

    }

}
