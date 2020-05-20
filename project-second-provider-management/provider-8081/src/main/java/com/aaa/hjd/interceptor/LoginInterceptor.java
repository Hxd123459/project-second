package com.aaa.hjd.interceptor;


import com.aaa.hjd.controller.LoginController;
import com.aaa.hjd.service.RedisService;
import com.aaa.hjd.utils.JSONUtil;
import com.aaa.hjd.vo.TokenVo;
import com.alibaba.dubbo.common.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/19 0019
 * Time: 12:02
 * Description:
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;
    @Autowired
    private LoginController loginController;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String bodyInfo = IOUtils.read(bufferedReader);
        TokenVo tokenVo = JSONUtil.toObject(bodyInfo, TokenVo.class);
        String redisOfValue = redisService.get(tokenVo.getRedisKey());
        //用户请求的地址
        StringBuffer requestUrl=request.getRequestURL();
        if (null==redisOfValue) {
            //说明 redis中没有值
            //然后判断redis中的值是否和用户传过来的一致
            loginController.turnLogin();
        }else {
            //说明redis中有值
            //判断用户传递过来的和redis中的是否相等
            if (redisOfValue.equals(tokenVo.getToken())) {
                return true;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
