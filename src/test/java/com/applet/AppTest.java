package com.applet;

import com.applet.mapper.SysAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private SysAdminMapper sysAdminMapper;

    @Test
    public void aaa() {
        System.out.println(sysAdminMapper.getAdmin());
    }


    @Test
    public void bbb() {
        System.out.println("6666");
    }
}
