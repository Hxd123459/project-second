package com.aaa.hjd.utils;

public class ObjectUtil {
    public static boolean checkIsNotNull(Object str){
        if(str!=null&&str!=""&&!str.equals("")){
            return true;
        }
        return false;
    }

    /**
     * Object转String
     * @param obj
     * @return
     */
    public static String transToString(Object obj){
        if(obj!=null){
            return obj.toString();
        }
        return "";
    }
    public static Integer transToInt(Object obj){
        if(obj!=null&&obj!=""){
            return Integer.parseInt(obj.toString());
        }
        return null;
    }
    public static Long transToLong(Object obj){
        if(obj!=null&&obj!=""){
            return Long.parseLong(obj.toString());
        }
        return null;
    }

}
