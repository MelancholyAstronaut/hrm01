package com.hrm.aynu_qhj;

import com.hrm.aynu_qhj.document.dao.DocumentInfDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AynuQhjApplicationTests {

    @Autowired
    private DocumentInfDao dao;

    @Test
    void contextLoads() {
      dao.queryAllDocument("ab").forEach(e -> System.out.println(e));

    }

}
