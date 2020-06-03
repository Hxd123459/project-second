package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMappingProject;
import com.aaa.hjd.service.MappingProjectService;
import com.aaa.hjd.service.ResourceService;
import com.aaa.hjd.utils.IdWorker;
import com.aaa.hjd.vo.TMappingProjectPageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/3 0003
 * Time: 14:06
 * Description:
 */
@RestController
public class MappingProjectController extends CommonController<TMappingProject> {
    @Autowired
    private MappingProjectService mappingProjectService;
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<TMappingProject> getBaseService() {
        return mappingProjectService;
    }

    @PostMapping("/getMappingProjectByPage")
    public ResultData getMappingProjectByPage(@RequestBody TMappingProjectPageVo mappingProjectPageVo){
        PageInfo<TMappingProject> tMappingProjectPageInfo = mappingProjectService.selectMappingProjectsByPage(mappingProjectPageVo);
        if (null!=tMappingProjectPageInfo) {
            return selectRoleSuccess(tMappingProjectPageInfo);
        }
        return selectFailed();
    }
    @PostMapping(value = "/addMappingProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData addMappingProject(@RequestPart(value = "fileOfRangeLine",required = false)
                                                MultipartFile fileOfRangeLine,
                                        @RequestPart(value = "fileOfRangeLine2",required = false)
                                                MultipartFile fileOfRangeLine2,
                                        @RequestPart(value = "fileOfRangeLine3",required = false)
                                                MultipartFile fileOfRangeLine3,
                                        @RequestPart(value = "fileOfContract",required = false)
                                                MultipartFile fileOfContract,
                                        @RequestPart(value = "fileOfContract2",required = false)
                                                MultipartFile fileOfContract2,
                                        @RequestPart(value = "fileOfContract3",required = false)
                                                MultipartFile fileOfContract3,
                                        @RequestParam(value = "coordinateSystem") String coordinateSystem,
                                        @RequestParam(value = "meridian") String meridian,
                                        @RequestParam(value = "projectType") String projectType,
                                        @RequestParam(value = "managementLevel") String managementLevel,
                                        @RequestParam(value = "fundingSource") String fundingSource,
                                        @RequestParam(value = "projectName") String projectName,
                                        @RequestParam(value = "heightDatum") String heightDatum,
                                        @RequestParam(value = "entrustUnit",required = false) String entrustUnit,
                                        @RequestParam(value = "acceptUnit",required = false) String acceptUnit,
                                        @RequestParam(value = "projectAmount",required = false) String projectAmount,
                                        @RequestParam(value = "projectLeader",required = false) String projectLeader,
                                        @RequestParam(value = "mobilePhone",required = false) String mobilePhone,
                                        @RequestParam(value = "phone",required = false) String phone,
                                        @RequestParam(value = "address",required = false) String address,
                                        @RequestParam(value = "startDate") String startDate,
                                        @RequestParam(value = "endDate",required = false) String endDate,
                                        @RequestParam(value = "acceptanceDepartment",required = false) String acceptanceDepartment,
                                        @RequestParam(value = "acceptanceReport",required = false) String acceptanceReport,
                                        @RequestParam(value = "projectArea",required = false) String projectArea,
                                        @RequestParam(value = "scale",required = false) String scale,
                                        @RequestParam(value = "sheetNumber",required = false) String sheetNumber,
                                        @RequestParam(value = "awardsDepartment",required = false) String awardsDepartment,
                                        @RequestParam(value = "prizeLevel",required = false) String prizeLevel,
                                        @RequestParam(value = "projectQualityApproval",required = false) String projectQualityApproval,
                                        @RequestParam(value = "winningTime",required = false) String winningTime,
                                        @RequestParam(value = "acceptanceTime",required = false) String acceptanceTime,
                                        @RequestParam(value = "basicContent",required = false) String basicContent,
                                        @RequestParam(value = "creditStatus",required = false) String creditStatus,
                                        @RequestParam(value = "submitStatus",required = false) String submitStatus,
                                        @RequestParam(value = "userId") Long userId){
        TMappingProject mappingProject = new TMappingProject();
        mappingProject.setId(new IdWorker().nextId()).setCoordinateSystem(coordinateSystem).setMeridian(meridian).setProjectType(projectType).setManagementLevel(managementLevel).setFundingSource(fundingSource).setProjectName(projectName)
                .setEntrustUnit(entrustUnit).setAcceptUnit(acceptUnit).setProjectAmount(projectAmount).setProjectLeader(projectLeader).setMobilePhone(mobilePhone).setPhone(phone).setAddress(address).setStartDate(startDate).setEndDate(endDate)
                .setAcceptanceDepartment(acceptanceDepartment).setAcceptanceReport(acceptanceReport).setProjectArea(projectArea).setScale(scale).setSheetNumber(sheetNumber).setAwardsDepartment(awardsDepartment).setPrizeLevel(prizeLevel)
                .setProjectQualityApproval(projectQualityApproval).setWinningTime(winningTime).setAcceptanceTime(acceptanceTime).setBasicContent(basicContent).setCreditStatus(creditStatus).setSubmitStatus(submitStatus).setUserId(userId);
        try {
            Integer addOfResult = mappingProjectService.addMappingProject(fileOfRangeLine, fileOfRangeLine2, fileOfRangeLine3,
                    fileOfContract, fileOfContract2, fileOfContract3,
                    mappingProject, resourceService);
            if (addOfResult==1) {
                return addDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addDataFailed();
    }

}
