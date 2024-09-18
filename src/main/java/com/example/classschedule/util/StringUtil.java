package com.example.classschedule.util;

import com.alibaba.druid.util.StringUtils;

public class StringUtil {
    public static boolean isNumeric(String str) {
        return StringUtils.isNumber(str);
    }
}
