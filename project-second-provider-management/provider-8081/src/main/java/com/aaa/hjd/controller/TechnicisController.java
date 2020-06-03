package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.vo.PageNumAndSize;
import com.aaa.hjd.model.Technicist;
import com.aaa.hjd.service.TechnicistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 * 技术人员信息
 */
@RestController
public class TechnicisController extends CommonController<Technicist> {

    @Autowired
    private TechnicistService technicistService;

    @Override
    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取技术人员信息，id需要根据当前登录用户获取
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getTechnicist")
    public ResultData getTechnicist(@RequestBody PageNumAndSize pageNumAndSize) {
        //获取session
        HttpSession session = getSession();
        //执行查询
        PageInfo<HashMap<String, Object>> pageInfo = technicistService.getTechnicistByUserId(session, pageNumAndSize);
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
     * 根据用户id获取技术人员信息
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getTechnicistByUserId")
    public ResultData getTechnicistByUserId(@RequestBody HashMap map) {
        //执行查询
        PageInfo<HashMap<String, Object>> pageInfo = technicistService.getTechnicistByUserId(map);
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
     * 根据id数组删除技术人员信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deleteTechnicistByIDs")
    public ResultData deleteTechnicistByIDs(@RequestBody List<Object> ids) {
        if (0 < ids.size()) {
            //当数不为null则执行删除
            return batchDelete(ids);
        }
        return delDataFailed();
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("insertTechnicist")
    public ResultData insertTechnicist(@RequestBody Technicist technicist) {

        if (null != technicist) {
            //新增
            Integer result = technicistService.insertTechnicist(technicist);
            if (0 < result) {
                return addDataSuccess();
            }
        }
        return addDataFailed();
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 修改技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist) {

        if (null != technicist) {
            //修改
            Integer result = technicistService.updateTechnicist(technicist);
            if (0 < result) {
                return updateDataSuccess();
            }
        }
        return updateDataFailed();
    }
}
