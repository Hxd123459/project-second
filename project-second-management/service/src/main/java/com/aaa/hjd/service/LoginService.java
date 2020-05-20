package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.TUserMapper;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aaa.hjd.status.RedisFlag.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 13:21
 * Description:
 */
@Service
public class LoginService {
    @Autowired
    private TUserMapper tUserMapper;
    public TokenVo doLogin(TUser tUser,RedisService redisService){
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);
        //1.判断(目前实现的是登录功能，也就是说用户在执行登录操作--->肯定没有token)
        if (null!=tUser) {
        //2.验证用户名和密码是否正确
            TUser resultOfTUser= tUserMapper.selectOne(tUser);
            // 3.判断如果从数据库中查询的user对象是否为null
                if (resultOfTUser!=null) {
               //说明用户已经登陆
                //生成用户的登陆标识，也就是redis的value
                String uuid = IdUtils.getUUID();
                //redis的key
                String keyOfRedis=String.valueOf(resultOfTUser.getId());
                resultOfTUser.setToken(uuid);
                int i = tUserMapper.updateByPrimaryKey(resultOfTUser);
                // 4.判断token是否更新成功
                if (i>0) {
                    // 说明token更新成功(需要返回token)
                    // 需要给token设置一个失效时间(因为以后每一个方法都需要去查好询token，也就是说必须要查询数据库)
                    // 就会大量影响效率(所以说直接存缓存)

                    //因为xx只有redis中存在该 key 的时候，才会执行成功
                    //所以去redis设置一下响应的key，因为这是登陆操作，就算是
                    //redis中有旧值，直接被覆盖即可
                    if (RESULT_REDIS.equals(redisService.set(keyOfRedis,uuid))) {
                        //说明已经设置好值，然后执行 xx
                        String resultOfRedis = redisService.set(keyOfRedis, uuid, XX, EX, 1800);
                        System.out.println("resultOfRedis="+resultOfRedis);
                        //resultOfRedis的值成功 返回OK
                        if (RESULT_REDIS.equals(resultOfRedis.toUpperCase())) {
                            return tokenVo.setIfSuccess(true).setToken(uuid)
                                    .setRedisKey(String.valueOf(resultOfTUser.getId()));
                        }
                    }
                }
            }
        }
        return tokenVo;
    }
}
