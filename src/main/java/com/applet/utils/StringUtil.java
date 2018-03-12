package com.applet.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    /**
     * 判断是不是空值
     *
     * @param patterns 需要判断的值
     * @return 空值为true, 否则false
     */
    public static Boolean isNull(String... patterns) {
        List<String> params = Arrays.asList(patterns);
        for (String param : params) {
            if (null == param || param.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
