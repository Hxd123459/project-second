package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.model.LoginLog;
import com.aaa.hjd.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/27
 */
@RestController
public class LoginLogController extends CommonController<LoginLog> {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }

    /**
     * @date:  2020/5/27
     * @author: 秀仔
     * @Description
     * 登录日志
     * @param [map]
     * @return com.aaa.zwc.base.ResultDate
     * @throws
     */
    @PostMapping("/addLoginLog")
    public void addLoginLog(@RequestBody HashMap<String, Object> map) {
        add(map);
    }
}
