package com.aaa.hjd.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/14 0014
 * Time: 19:42
 * Description:
 * 文件名称生成工具类
 */
public class FileNameUtils {
    public static String getFileName(String oldFileName){
        int index = oldFileName.indexOf(".");
        String suffix = oldFileName.substring(index);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMddHHmmss");
        String format = simpleDateFormat.format(date);
        int i=0;
        do{
            i = new Random().nextInt(1000);
        }while (i<100&&i>999);
        String newFileName=format+String.valueOf(i)+suffix;
        return newFileName;
    }
}
