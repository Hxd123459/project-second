package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.RoleMapper;
import com.aaa.hjd.model.Role;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.vo.RoleSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Aurora
 * Date: 2020/5/21
 * Time: 0:34
 */
@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> selectByNameOrTime(RoleSelecter roleSelecter){
        return roleMapper.selectByNameOrTime(roleSelecter);
    }
}
