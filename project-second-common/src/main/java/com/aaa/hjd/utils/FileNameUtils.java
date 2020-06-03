package com.aaa.hjd.utils;

import java.util.Date;
import java.util.Random;

import static com.aaa.hjd.status.TimeProperties.TIME_TYPE03;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/29 14:57
 * @Description
 **/
public class FileNameUtils {

    private FileNameUtils() {

    }

    /**
     * @author Seven Lee
     * @description
     *      文件名的生成方法
     * @param []
     * @date 2020/5/29
     * @return java.lang.String
     * @throws
    **/
    public static String getFileName() {
        // 1.获取系统当前时间
        String s = DateUtils.formatDate(new Date(), TIME_TYPE03);
        // 2.创建Random对象
        Random random = new Random();
        // 3.做一个随机数，随机区间是0-999之间随机
        Integer randomNum = random.nextInt(999);
        // 4.生成最终的文件名(当前系统时间的毫秒数+随机数 来实现)
        /**
         * %:占位符
         * d:数字
         * 03:三位数，如果不够三位自动向前补0
         */
        String fileName = s + String.format("%03d", randomNum);
        // 5.返回文件名称
        return fileName;
    }
}
