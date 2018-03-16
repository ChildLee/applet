package com.applet;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ApplicationTest {

    Long a;

    @Test
    public void asList() {
        a(a, "a", new Long(3));
    }

    public void a(Object... patterns) {
        List<Object> params = Arrays.asList(patterns);
        for (Object param : params) {
            if (param == null) {
                System.out.println(1);
            } else if (param instanceof String) {
                System.out.println(2);
            } else if (param instanceof Long) {
                System.out.println(3);
            }
        }
    }
}
