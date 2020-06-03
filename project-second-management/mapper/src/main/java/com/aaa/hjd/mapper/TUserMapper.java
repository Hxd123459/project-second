package com.aaa.hjd.mapper;

import com.aaa.hjd.model.TUser;
import com.aaa.hjd.vo.UpdateUserVo;
import com.aaa.hjd.vo.UserSelectVo;
import tk.mybatis.mapper.common.Mapper;


import java.util.HashMap;
import java.util.List;

public interface TUserMapper extends Mapper<TUser> {
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有用户信息
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getUserAll();
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有角色
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getRoleAll();

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据id获取用户的所有角色
     * @param [id]
     * @return java.util.List<java.lang.Long>
     * @throws
     */
    List<Long> getUserRoleByID(Long id);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据用户id删除用户所有角色
     * @param [id]
     * @return java.lang.Integer
     * @throws
     */
    Integer deleteUserRoleByID(Long id);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 跟新用户角色信息
     * @param [updataUserVo]
     * @return java.lang.Integer
     * @throws
     */
    Integer insertUserRole(HashMap map);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据parentID获取部门名
     * @param [parentID]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getDept(Long parentID);

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 查询用户名是否已存在
     * @param [username]
     * @return java.lang.Long
     * @throws
     */
    Long getUserByUsername(String username);
    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 模糊查询
     * @param [userSelectVo]
     * @return java.util.List<com.aaa.hjd.vo.UserSelectVo>
     * @throws
     */
    List<HashMap<String, Object>> selectUser(UserSelectVo userSelectVo);

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表状态值
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getUserStatus();

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表性别
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getUserSsex();
}