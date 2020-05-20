package com.aaa.hjd.utils;

import java.util.UUID;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/15 16:33
 * @Description
 **/
public class IdUtils {

    private IdUtils() {}

    /**
     * @author Seven Lee
     * @description
     *      获取uuid
     * @date 2020/5/15
     * @return java.lang.String
     * @throws
    **/
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
