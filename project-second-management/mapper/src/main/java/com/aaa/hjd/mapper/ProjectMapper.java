package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Project;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author xxf
 */
public interface ProjectMapper extends Mapper<Project> {

    /**
     * @param map
     * @return
     * 根据单位表的员工id查询关联的项目信息+搜索
     */
    List<Project> selectByUserId(Project project);
}