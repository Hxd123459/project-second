package com.aaa.hjd.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: Aurora
 * Date: 2020/5/21
 * Time: 1:33
 * 时间工具类
 */
public class DateTimeUtils {

    /**
     * 获取当前时间字符串 格式 yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String getNow(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        return format;
    }
}
