package com.applet;

import com.applet.entity.SysAccess;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
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

    private void a(Object... patterns) {
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

    @Test
    public void b() throws IOException {
        String a = "[{\"id\":38,\"name\":\"增删改查\",\"path\":\"/get\",\"roles\":null},{\"id\":49,\"name\":\"登录\",\"path\":\"/login\",\"roles\":null}]";
        ObjectMapper mapper = new ObjectMapper();
        List<SysAccess> accesses = mapper.readValue(a, new TypeReference<List<SysAccess>>() {
        });
        System.out.println(accesses.get(0).getName());
    }
}
