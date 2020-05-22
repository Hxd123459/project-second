package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.BaseController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 12:20
 * Description:
 *  登陆 的控制层
 */
@RestController
@Api(value = "登陆模块",tags = "用户登录接口")
public class LoginController extends BaseController {
    @Autowired
    private PubService pubService;

    @PostMapping("/doLogin")
    @ApiOperation(value = "登陆功能",notes = "用户执行登陆功能")
    public ResultData doLogin(@RequestBody TUser tUser){
        TokenVo tokenVo = pubService.doLogin(tUser);
        if (tokenVo.getIfSuccess()) {
            return loginSuccess(tokenVo);
        }
        return loginFailed();
    }

    @RequestMapping("/turnLogin")
    public TokenVo turnLogin(){
        System.out.println("拦截器返回");
        return pubService.turnLogin();
    }
}
