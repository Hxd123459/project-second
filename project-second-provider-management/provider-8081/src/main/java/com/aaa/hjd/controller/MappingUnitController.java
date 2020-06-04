package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.service.SurveyingUnitService;
import com.aaa.hjd.utils.ObjectUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 * 单位信息
 */
@RestController
public class MappingUnitController extends CommonController<TMappingUnit> {

    @Autowired
    private SurveyingUnitService surveyingUnitService;
    @Override
    public BaseService<TMappingUnit> getBaseService() {
        return surveyingUnitService;
    }


    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息,自动获取当前用户id
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getMappingUnit")
    public ResultData getMappingUnit() {
        //获取session
        HttpSession session = getSession();
        //执行查询
        HashMap<String, Object> mappingUnit = surveyingUnitService.getMappingUnitByUserId(session);
        if (null != mappingUnit){
            //返回成功
            return selectSuccessZ(mappingUnit);
        }
        return selectFailedZ();
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getMappingUnitByUserId")
    public ResultData getMappingUnitByUserId(@RequestParam("userId")Long userId) {
        //执行查询
        HashMap<String, Object> mappingUnit = surveyingUnitService.getMappingUnitByUserId(userId);
        if (null != mappingUnit){
            //返回成功
            return selectSuccessZ(mappingUnit);
        }
        return selectFailedZ();
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 更新单位信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody TMappingUnit tMappingUnit) {
        System.out.println(tMappingUnit);
        Integer result = surveyingUnitService.updateMappingUnit(tMappingUnit);
        if (null != result && 0 < result) {
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * @Author xxf
     * @Description
     *      查询所有的单位信息+分页+搜索
     * @Date 11:53 2020/5/27
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUnitList")
    public ResultData selectUnitList(@RequestBody HashMap map){
        PageInfo<TMappingUnit> tMappingUnitPageInfo = surveyingUnitService.selectUnitList(map);
        if (tMappingUnitPageInfo == null){
            return selectFailedZ("暂无数据");
        }
        return selectRoleSuccess(tMappingUnitPageInfo);
    }

    /**
     * @Author xxf
     * @Description
     *      查询一条数据
     * @Date 11:06 2020/5/29
     * @Param [tMappingUnit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUnitOne")
    public ResultData selectUnitOne(@RequestBody TMappingUnit tMappingUnit){
        TMappingUnit tMappingUnit1 = surveyingUnitService.selectOne(tMappingUnit);
        if (tMappingUnit1 == null) {
            return super.selectFailedZ("暂无数据");
        }
        return super.selectSuccess(tMappingUnit1);
    }

    /**
     * @Author xxf
     * @Description
     *      查询修改待审核的单位信息+搜索+分页
     * @Date 10:55 2020/5/31
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectAuditForUpdate")
    public ResultData selectAuditForUpdate(@RequestBody HashMap map) {
        PageInfo<TMappingUnit> pageInfo = surveyingUnitService.selectAuditForUpdate(map);
        if (pageInfo == null) {
            return super.selectFailedZ("暂无数据");
        }
        return super.selectSuccess(pageInfo);
    }

}
