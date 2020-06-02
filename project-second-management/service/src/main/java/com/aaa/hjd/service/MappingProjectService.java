package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.TMappingProjectMapper;
import com.aaa.hjd.model.TMappingProject;
import com.aaa.hjd.vo.TMappingProjectPageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/25 0025
 * Time: 23:11
 * Description:
 */
@Service
public class MappingProject extends BaseService<TMappingProject> {
    @Autowired
    private TMappingProjectMapper tMappingProjectMapper;

    public PageInfo<TMappingProject> selectMappingProjectByPage(TMappingProjectPageVo tMappingProjectPageVo){
        try {
            PageInfo<TMappingProject> tMappingProjectPageInfo = super.queryListPage(null, tMappingProjectPageVo.getPageNum(), tMappingProjectPageVo.getPageSize());
            return tMappingProjectPageInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
