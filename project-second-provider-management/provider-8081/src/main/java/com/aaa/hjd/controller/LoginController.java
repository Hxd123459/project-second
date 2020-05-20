package com.aaa.hjd.controller;

import com.aaa.hjd.model.TUser;
import com.aaa.hjd.service.LoginService;
import com.aaa.hjd.service.RedisService;
import com.aaa.hjd.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 13:20
 * Description:
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;
    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody TUser user){
       return loginService.doLogin(user,redisService);
    }
    @RequestMapping("/turnLogin")
    public TokenVo turnLogin(){
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);
        System.out.println("拦截器返回");
        return tokenVo;
    }
}
