package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Role;
import com.aaa.hjd.vo.RoleSelecter;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> selectByNameOrTime(RoleSelecter roleSelecter);
}