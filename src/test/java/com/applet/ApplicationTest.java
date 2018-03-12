package com.applet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void asList() {
        a("a", "b", "c");
    }

    public void a(String... patterns) {
        List<String> params = Arrays.asList(patterns);
        for (String param : params) {
            System.out.println(param);
        }
    }
}
