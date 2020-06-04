package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Project;
import com.aaa.hjd.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: xxf
 * @Time: Create in 2020/5/29  16:14
 * @Description:
 */
@RestController
public class ProjectController extends CommonController<Project> {
    @Override
    public BaseService<Project> getBaseService() {
        return projectService;
    }
    @Autowired
    private ProjectService projectService;

    /**
     * @Author xxf
     * @Description
     * 根据单位表的user_id查询项目信息+搜索+分页
     * @Date 16:18 2020/5/29
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectProjectByUserId")
    public ResultData selectByUserId(@RequestBody HashMap map){
        PageInfo<Project> projectPageInfo = projectService.selectByUserId(map);
        if (projectPageInfo == null) {
            return super.selectFailedZ("暂无数据");
        }
        return super.selectSuccess(projectPageInfo);
    }
}
