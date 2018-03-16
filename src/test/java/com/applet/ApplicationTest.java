package com.applet;

import com.applet.entity.SysAccess;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ApplicationTest {

    Long a;

    @Test
    public void asList() {
        SysAccess sysAccess = new SysAccess();
        sysAccess.setId((long) 1);
        sysAccess.setName("2");
        sysAccess.setPath("3");
        a(sysAccess);
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
            } else if (param instanceof Object) {
                System.out.println(4);
            }

        }
    }
}
