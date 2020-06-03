package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Principal;
import com.aaa.hjd.model.SpecialPost;
import com.aaa.hjd.service.SpecialPostService;
import com.aaa.hjd.vo.PageNumAndSize;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/28
 * 特殊岗位人员信息
 */
@RestController
public class SpecialPostController extends CommonController<SpecialPost> {

    @Autowired
    private SpecialPostService specialPostService;

    @Override
    public BaseService<SpecialPost> getBaseService() {
        return specialPostService;
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id特殊人员信息，自动获取当前登录的用户id
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getSpecialPost")
    public ResultData getSpecialPost(@RequestBody PageNumAndSize pageNumAndSize) {
        //获取session
        HttpSession session = getSession();
        //执行查询
        PageInfo<HashMap<String, Object>> pageInfo = specialPostService.getSpecialPostByUserId(session, pageNumAndSize);
        if (null != pageInfo){
            //返回成功
            return selectSuccessZ(pageInfo);
        }
        return selectFailedZ();
    }


    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取特殊人员信息
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getSpecialPostByUserId")
    public ResultData getSpecialPostByUserId(@RequestBody HashMap map) {
        //执行查询
        PageInfo<HashMap<String, Object>> pageInfo = specialPostService.getSpecialPostByUserId(map);
        if (null != pageInfo){
            //返回成功
            return selectSuccessZ(pageInfo);
        }
        return selectFailedZ();
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增特殊人员信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("addSpecialPost")
    public ResultData addSpecialPost (@RequestBody SpecialPost specialPost) {
        if (null!= specialPost) {
            Integer insert = specialPostService.insertSpecialPost(specialPost);
            if (0 < insert) {
                //新增数据成功
                return addDataSuccess();
            }
        }
        return addDataFailed();
    }

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 修改特殊人员信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost) {
        if (null != specialPost){
            //执行更新
            Integer integer = specialPostService.updateSpecialPost(specialPost);
            if (null != integer && 0 < integer) {
                //返回成功
                return updateDataSuccess();
            }
        }
        //返回失败
        return updateDataFailed();
    }

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 删除特殊人员信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deleteSpecialPostByIDs")
    public ResultData deleteSpecialPostByIDs(@RequestBody List<Object> ids) {
        if (0 < ids.size()) {
            //删除数据,并返回
            return batchDelete(ids);
        }
        //返回失败
        return delDataFailed();
    }
}
