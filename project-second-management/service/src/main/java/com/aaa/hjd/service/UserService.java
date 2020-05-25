package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseModel;
import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.mapper.TUserMapper;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.vo.UpdateUserVo;
import com.aaa.hjd.vo.UserSelectVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

import static com.aaa.hjd.status.StatusCodeAndMsg.ADD_DATA_SUCCESS;
import static com.aaa.hjd.status.StatusCodeAndMsg.USER_EXIST;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/22
 */
@Service
public class UserService extends BaseService<TUser> {

    @Autowired
    private TUserMapper userMapper;

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有用户信息带分页
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public PageInfo getUserAll(HashMap<String, Integer> map){
        PageHelper.startPage(ObjectUtil.transToInt(map.get("pageNum")),ObjectUtil.transToInt(map.get("pageSize")));
        //查询所有数据
        List<HashMap<String, Object>> userAll = userMapper.getUserAll();
        //获取分页信息
        PageInfo pageInfo = new PageInfo(userAll);
        if (null != pageInfo){
            //返回数据
            return pageInfo;
        }
        return null;
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有角色
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public List<HashMap<String, Object>> getRoleAll() {
        //获取所有角色
        List<HashMap<String, Object>> roleAll = userMapper.getRoleAll();
        if (null != roleAll && 0 < roleAll.size()){
            //返回角色信息
            return roleAll;
        }
        return null;
    }

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据id获取用户的所有角色
     * @param [id]
     * @return java.util.List<java.lang.Long>
     * @throws
     */
     public List<Long> getUserRoleByID(Long id){
         //根据id获取用户信息学
         List<Long> roleID = userMapper.getUserRoleByID(id);
         if (null != roleID && 0 < roleID.size()){
             return roleID;
         }
         return null;
     }
     /**
      * @date:  2020/5/22
      * @author: 秀仔
      * @Description
      * 根据ids删除所有用户
      * @param []
      * @return java.lang.Integer
      * @throws
      */
     public Integer deleteUserByIDs (List list){
         if (null != list && 0 < list.size()){
             //list不为null执行删除
             Integer integer = deleteUserByIDs(list);
             if (null != integer && 0 < integer){
                 //返回受影响条数
                 return integer;
             }
         }
         return null;
     }
     /**
      * @date:  2020/5/22
      * @author: 秀仔
      * @Description
      * 根据用户id修改用户信息
      * @param []
      * @return java.lang.Integer
      * @throws
      */
     @Transactional
     public Integer updataUserByID (UpdateUserVo updateUserVo) {
         try {
             //根据用户的id删除用户的所有角色
             Integer delRole = userMapper.deleteUserRoleByID(updateUserVo.getId());
             //判断是否需要新增角色
             if (updateUserVo.getRoleIDs().size()>0){
                 //为用户新增新的角色
                 HashMap map = new HashMap();
                 //放入用户id
                 map.put("id",updateUserVo.getId());
                 //放入角色id数组
                 map.put("roleIDs", updateUserVo.getRoleIDs());
                 //执行新增
                 Integer updataRole = userMapper.insertUserRole(map);
             }
             //修改用户信息，设置当前修改时间
             updateUserVo.getUser().setModifyTime(DateTimeUtils.getNow());
             Integer update = update(updateUserVo.getUser());
             //返回受影响条数
             if (null != update && 0 < update){
                 return update;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 新增用户
     * @param [updateUserVo]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @Transactional
    public ResultData addUser(UpdateUserVo updateUserVo) {
        ResultData resultData = new ResultData();
        //查看用户名是否存在
        Long id = userMapper.getUserByUsername(updateUserVo.getUser().getUsername());
        if (null != id && 0 < id){
            //用户名已存在
            return resultData.setCode(USER_EXIST.getCode()).setMsg(USER_EXIST.getMsg());
        }
        //设置创建时间
        updateUserVo.getUser().setCreateTime(DateTimeUtils.getNow());
        //执行新增
        Integer addUser = userMapper.insertSelective(updateUserVo.getUser());
        //获取新增用户主键
        Long userID = updateUserVo.getUser().getId();
        //判断是否需要新增角色
        if (updateUserVo.getRoleIDs().size()>0){
            //为用户新增新的角色
            HashMap map = new HashMap();
            //放入用户id
            map.put("id",userID);
            //放入角色id数组
            map.put("roleIDs", updateUserVo.getRoleIDs());
            //新增角色
            Integer updataRole = userMapper.insertUserRole(map);
        }
        if (null != addUser && 0 < addUser){
            //新增成功
            return resultData.setCode(ADD_DATA_SUCCESS.getCode()).setMsg(ADD_DATA_SUCCESS.getMsg());
        }
        return null;
    }

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据parentID获取部门名
     * @param [parentID]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public List<HashMap<String, Object>> getDept(Long parentID) {
        //根据parentID查询部门
        List<HashMap<String, Object>> depts = userMapper.getDept(parentID);
        if (depts.size() > 0){
            for (HashMap<String, Object> dept : depts) {
                //用id当parentID查询子部门
                List<HashMap<String, Object>> list = getDept(ObjectUtil.transToLong(dept.get("DEPT_ID")));
                //放到夫菜单的children字段中
                dept.put("children",list);
            }
        }
        //循环完成返回数据
        return depts;
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表状态值
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public List<HashMap<String, Object>> getUserStatus(){
        //执行查询
        List<HashMap<String, Object>> userStatus = userMapper.getUserStatus();
        if (null != userStatus && 0 < userStatus.size()){
            //有数据返回
            return userStatus;
        }
        return null;
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表性别
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public List<HashMap<String, Object>> getUserSsex(){
        //执行查询
        List<HashMap<String, Object>> userSsex = userMapper.getUserSsex();
        if (null != userSsex && 0 < userSsex.size()){
            //有数据返回
            return userSsex;
        }
        return null;
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 模糊分页查询
     * @param [userSelectVo]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public List<HashMap<String, Object>>  selectUser(UserSelectVo userSelectVo){
        List<HashMap<String, Object>> list = userMapper.selectUser(userSelectVo);
        return list;
    }

}
