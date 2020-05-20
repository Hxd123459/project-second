package com.aaa.hjd.service;

import com.aaa.hjd.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import static com.aaa.hjd.status.RedisFlag.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/13 0013
 * Time: 19:07
 * Description:
 */
@Service
public class RedisService<T> {
    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 向redis中放值
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value){
        return jedisCluster.set(key, value);
    }

    /**
     * 从redis中取值
     * @param key
     * @return
     */
    public String get(String key){
        return jedisCluster.get(key);
    }

    /**
     * 为指定的redis中的key设置失效时间
     * @param key
     * @param seconds
     * @return
     */
    public Long setWithExpire(String key,int seconds){
        return jedisCluster.expire(key,seconds);
    }


    /**
     * 用户登录后，给该用户的token设置失效时间
     * @param key
     * @param value
     * @param nxxx：
     *              "nx":如果redis中key不存在，则可以存数据
     *             "xx":如果redis中的key存在，则才可以存储数据
     * @param expx：
     *             "ex": ex的失效时间单位为秒
     *            "px":  px的失效时间单位为毫秒
     * @param seconds
     * @return
     */
    public String set(String key,T value,String nxxx,String expx,Integer seconds){
        if (null!=seconds && 0<seconds && null!=key && null!=value) {
            return jedisCluster.set(key, JSONUtil.toJsonString(value), nxxx, expx, seconds);
        }else {
            // 说明不需要设置失效时间
            // 就算不需要失效时间，但是我也得知道最终你所传递的是nx还是xx，所以需要再次判断
            if(NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtil.toJsonString(value)));
            } else if(XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtil.toJsonString(value));
            }
        }
        return NO;
    }
}
