package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.mapper.PrincipalMapper;
import com.aaa.hjd.model.Principal;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.vo.PageNumAndSize;
import com.aaa.hjd.vo.TokenVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 * 单位负责人信息
 */
@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位负责人信息,自动获取当前登录用户的id
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    public PageInfo getPrincipalByUserId(HttpSession session, PageNumAndSize pageNumAndSize){
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("tokenVo");
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //分页
        PageHelper.startPage(pageNumAndSize.getPageNum(), pageNumAndSize.getPageSize());
        //根据用户id查询单位信息
        List<HashMap<String, Object>> list = principalMapper.getPrincipalByUserId(id);
        if(0 < list.size()){
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位负责人信息
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    public PageInfo getPrincipalByUserId(HashMap map){

        //获取相关用户的id，转换类型
        Long id = ObjectUtil.transToLong(map.get("userId"));
        //分页
        PageHelper.startPage(ObjectUtil.transToInt(map.get("pageNum")), ObjectUtil.transToInt(map.get("pageSize")));
        //根据用户id查询单位信息
        List<HashMap<String, Object>> list = principalMapper.getPrincipalByUserId(id);
        if(0 < list.size()){
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }
    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增单位负责人信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer addPrincipal (Principal principal) {

        if (null != principal) {
            //获取当前时间
            String now = DateTimeUtils.getNow();
            //设置创建时间
            principal.setCreateTime(now);
            //设置Long类型的id
            principal.setId(IdUtils.getLongID());
            //执行新增
            int insert = principalMapper.insert(principal);
            if (0 < insert) {
                return insert;
            }
        }
        return null;
    }

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 修改单位负责人信息
     * @param
     * @return
     * @throws
     */
    public Integer updatePrincipal(Principal principal) {
        if (null != principal) {
            //设置修改时间
            principal.setModifyTime(DateTimeUtils.getNow());
            //更新数据
            Integer result = principalMapper.updateByPrimaryKeySelective(principal);
            if (null != result && 0 < result) {
                //返回受影响条数
                return result;
            }
        }
        return null;
    }
    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 查询单位负责人附件信息
     * @param
     * @return
     * @throws
     */
    public List<HashMap<String, Object>> getPrincipalResource(Long principalId) {

        if (null != principalId) {
            //查询附件信息
            List<HashMap<String, Object>> list = principalMapper.getPrincipalResource(principalId);
            if (0 < list.size()) {
                return list;
            }
        }
        return null;
    }
}
