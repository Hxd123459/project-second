package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.ProjectMapper;
import com.aaa.hjd.model.Project;
import com.aaa.hjd.utils.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/29  15:57
 * @Description:
 */
@Service
public class ProjectService extends BaseService<Project> {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * @Author xxf
     * @Description
     *  根据单位表种的user_id查询项目信息+搜索+分页
     * @Date 16:15 2020/5/29
     * @Param [map]
     * @return com.github.pagehelper.PageInfo<com.aaa.hjd.model.Project>
     * @throws
     **/
    public PageInfo<Project> selectByUserId(HashMap map) {
        //获取分页信息
        Integer pageNum = ObjectUtil.transToInt(map.get("pageNum"));
        Integer pageSize = ObjectUtil.transToInt(map.get("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        //获取查询条件
        Project project = new Project();
        Long userId = ObjectUtil.transToLong(map.get("userId"));
        String projectName = ObjectUtil.transToString(map.get("projectName"));
        if (projectName == null || "".equals(projectName)) {
            project.setUserId(userId);
        }else {
            project.setUserId(userId).setProjectName(projectName);
        }

        //进行查询
        List<Project> projects = projectMapper.selectByUserId(project);
        //判断查询结果是否为空
        if (projects.size() > 0) {
            return new PageInfo(projects);
        }
        return null;
    }
}
