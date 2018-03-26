package com.applet.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    /**
     * 判断是不是空值和空字符串
     *
     * @param patterns 需要判断的值
     * @return 空值为true, 否则false
     */
    public static Boolean isNull(Object... patterns) {
        if (null == patterns) return true;
        List<Object> params = Arrays.asList(patterns);
        for (Object param : params) {
            if (param == null) return true;
            if (param instanceof String && ((String) param).trim().isEmpty()) return true;
        }
        return false;
    }
}
