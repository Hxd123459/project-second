package com.aaa.hjd;

import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Role;
import com.aaa.hjd.vo.RoleMenuSelecter;
import com.aaa.hjd.vo.RoleSelecter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "system-interface")
public interface IRoleService {

    @GetMapping("/selectAllRole")
    ResultData selectAllRole();

    @PutMapping("/insertRole")
    ResultData insertRole(@RequestBody Role role);

    @DeleteMapping("/deleteRole")
    ResultData deleteRole(@RequestBody List<Object> list);

    @PostMapping("/updateRole")
    ResultData updateRole(@RequestBody RoleMenuSelecter roleMenuSelecter);

    @PostMapping("/selectRoleMenuById")
    ResultData selectRoleMenuById(@RequestBody Role role);

    @PostMapping("/selectByNameOrTime")
    ResultData selectByNameOrTime(@RequestBody RoleSelecter roleSelecter);
}
