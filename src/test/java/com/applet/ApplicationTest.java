package com.applet;

import com.applet.entity.SysAccess;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ApplicationTest {

    Long a = (long) 1;

    @Test
    public void asList() {
        a(a);
    }

    private void a(Object... patterns) {
        if (null == patterns) return;
        List<Object> params = Arrays.asList(patterns);
        for (Object param : params) {
            if (null == param) System.out.println("null");
//            if (param instanceof Integer) System.out.println(param);
            if (param instanceof Long) System.out.println(param);
//            if (param instanceof String) System.out.println(param);
        }
    }

    @Test
    public void b() throws IOException {
        String a = "[{\"id\":38,\"name\":\"增删改查\",\"path\":\"/get\",\"roles\":null},{\"id\":49,\"name\":\"登录\",\"path\":\"/login\",\"roles\":null}]";
        ObjectMapper mapper = new ObjectMapper();
        List<SysAccess> accesses = mapper.readValue(a, new TypeReference<List<SysAccess>>() {
        });
        System.out.println(accesses.get(0));
    }

    @Test
    public void aaa() {
        String[] imgArr = null;
        System.out.println(null == imgArr);
    }
}
