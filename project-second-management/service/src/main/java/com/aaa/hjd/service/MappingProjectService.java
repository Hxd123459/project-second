package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.TMappingProjectMapper;
import com.aaa.hjd.model.Resource;
import com.aaa.hjd.model.TMappingProject;
import com.aaa.hjd.utils.DateUtils;
import com.aaa.hjd.utils.FileNameUtils;
import com.aaa.hjd.utils.FtpUtils;
import com.aaa.hjd.utils.IdWorker;
import com.aaa.hjd.vo.TMappingProjectPageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import static com.aaa.hjd.status.FtpIpProperties.*;
import static com.aaa.hjd.status.TimeProperties.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/3 0003
 * Time: 12:20
 * Description:
 */
@Service
public class MappingProjectService extends BaseService<TMappingProject> {
    @Autowired
    private TMappingProjectMapper tMappingProjectMapper;
    /**
     *查询指定用户的项目信息，带有分页
     * @param mappingProjectPageVo
     * @return
     */
    public PageInfo<TMappingProject> selectMappingProjectsByPage(TMappingProjectPageVo mappingProjectPageVo){
        try {
            PageInfo<TMappingProject> mappingProjectPageInfo = super.queryListPage(mappingProjectPageVo.getMappingProject(), mappingProjectPageVo.getPageNum(),
                    mappingProjectPageVo.getPageSize());
            return mappingProjectPageInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加项目信息
     * @param file1
     * @param file2
     * @param file3
     * @param file4
     * @param file5
     * @param file6
     * @param mappingProject
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer addMappingProject(MultipartFile file1, MultipartFile file2, MultipartFile file3,
                                     MultipartFile file4, MultipartFile file5, MultipartFile file6,
                                     TMappingProject mappingProject, ResourceService resourceService) throws Exception {
        if (null!=file1) {
            Boolean aBoolean1 = beforeToDo(file1, "附件", resourceService);
            System.out.println("aBoolean1"+aBoolean1);
        }
        if (null!=file2) {
            Boolean aBoolean2 = beforeToDo(file2, "附件", resourceService);
        }
        if (null!=file3) {
            Boolean aBoolean3 = beforeToDo(file3, "附件", resourceService);
        }
        if (null!=file4) {
            Boolean aBoolean4 = beforeToDo(file4, "附件", resourceService);
        }
        if (null!=file5) {
            Boolean aBoolean5 = beforeToDo(file5, "附件", resourceService);
        }
        if (null!=file6) {
            Boolean aBoolean6 = beforeToDo(file6, "附件", resourceService);
        }
        if (null!=file4||null!=file5||null!=file6) {
            //说明有合同上传,需要设置mappingProject的合同上传日期
            mappingProject.setContractTime(DateUtils.formatDate(new Date(),TIME_TYPE));
        }
        Integer addOfResult= super.add(mappingProject);
        return addOfResult;

    }

    private Boolean beforeToDo(MultipartFile file,String refBizType,ResourceService resourceService) throws Exception {
        String filePath= DateUtils.formatDate(new Date(),TIME_TYPE02);
        String suffix="."+file.getOriginalFilename().split("\\.")[1];
        String newFileName= FileNameUtils.getFileName()+suffix;
        String createTimeAndModifyTime=DateUtils.formatDate(new Date(),TIME_TYPE);
        boolean uploadFileOfResult = FtpUtils.UploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newFileName, file.getInputStream());
        //将数据放到t_resource中
        Resource resource = new Resource();
        resource.setId(new IdWorker().nextId())
                .setName(file.getOriginalFilename())
                .setSize(file.getSize())
                .setPath(FTP_IP+"/"+filePath+"/"+newFileName)
                .setExtName(suffix)
                .setRefBizType(refBizType)
                .setCreateTime(createTimeAndModifyTime)
                .setModifyTime(createTimeAndModifyTime);
        Integer add = resourceService.add(resource);
        if (add==1&&uploadFileOfResult) {
            return true;
        }
        return false;
    }
}
