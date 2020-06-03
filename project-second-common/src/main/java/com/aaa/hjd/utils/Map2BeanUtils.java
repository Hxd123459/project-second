package com.aaa.hjd.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/12 0012
 * Time: 18:44
 * Description:
 *   map转bean的工具类
 */
public class Map2BeanUtils {
    /**
     * 以后写工具类，先将构造器私有化。
     * 强制他人使用类名.方法名的方式调用工具类
     */
    private Map2BeanUtils(){}

    /**
     * 使用高性能java实例工具，参数 true 代表开启缓存
     */
    private final static Objenesis OBJENESIS=new ObjenesisStd(true);
    /**
     *  StringBuffer的性能虽然次于StringBuilder，但是StringBuffer是线程安全的
     */
    private final static StringBuffer STRING_BUFFER=new StringBuffer();
    /**
     * 使用Map集合作用本地缓存池来使用(也必须要保证线程安全)
     */
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP=new ConcurrentHashMap<Class, MethodAccess>();

    public static <T> T map2Bean(Map<String,Object> map,Class<T> clazz){
        // 通过clazz类型获取泛型对象(获取咱们所需要的对象)(但是这个对象是一个空对象)
        T instance=OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        if (null==methodAccess) {
            methodAccess = MethodAccess.get(clazz);
            // Map中是以key和value存在的
            // map.put("username", "zhangsan");
            // map.put("username", "lisi");--->lisi就把zhangsan覆盖了
            // map.putIfAbsent("username", "wangwu");--->wangwu并不会存放，因为username这个key已经存在
            // 就是为了获取下一步的get和set方法

            CONCURRENT_HASH_MAP.put(clazz,methodAccess);
        }
        for (Map.Entry<String,Object> entry:map.entrySet()) {
            String setMethodName = setMethodName(entry.getKey());
            int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
            methodAccess.invoke(instance,index,entry.getValue());
        }
        return instance;
    }

    /**
     * 通过字段获取set的方法名
     * @param fieldName
     * @return
     */
    private static String setMethodName(String fieldName){
        // fieldName--->bookName--->getBookName()
        // 所以第一步并不是直接获取，而是先把这个字段的首字母大写
        String fieldJava=firstToUpperCase(fieldName);
        // 确保了StringBuffer中没有任何数据
        STRING_BUFFER.setLength(0);
        //拼接set方法
        return STRING_BUFFER.append("set").append(fieldJava).toString();
    }

    /**
     * 把String类型字符串的首字母大写
     * @param field
     * @return
     */
    private static String firstToUpperCase(String field){
        return field.substring(0,1).toUpperCase()+field.substring(1);
    }
}
