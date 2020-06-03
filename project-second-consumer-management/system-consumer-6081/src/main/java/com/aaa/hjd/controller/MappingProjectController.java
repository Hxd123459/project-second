package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.vo.TMappingProjectPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/26 0026
 * Time: 11:23
 * Description:
 */
@RestController
@Api(value = "项目管理模块",tags = "项目管理")
public class MappingProjectController {
    @Autowired
    private PubService pubService;

    @PostMapping("/getMappingProjectByPage")
    @ApiOperation(value ="获取当前企业用户的项目信息",notes = "需要填写用户的id和分页信息")
    public ResultData getMappingProjectByPage(@RequestBody TMappingProjectPageVo mappingProjectPageVo){
     return pubService.getMappingProjectByPage(mappingProjectPageVo);
    }

    @PostMapping(value = "/addMappingProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="添加项目信息（含有文件上传）",notes = "填写项目信息")
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
        System.out.println(fileOfContract.getOriginalFilename());
        return pubService.addMappingProject(fileOfRangeLine, fileOfRangeLine2, fileOfRangeLine3, fileOfContract, fileOfContract2, fileOfContract3
                , coordinateSystem, meridian, projectType, managementLevel, fundingSource, projectName, heightDatum, entrustUnit
                , acceptUnit, projectAmount, projectLeader, mobilePhone, phone, address, startDate, endDate, acceptanceDepartment
                , acceptanceReport, projectArea, scale, sheetNumber, awardsDepartment, prizeLevel, projectQualityApproval
                , winningTime, acceptanceTime, basicContent, creditStatus, submitStatus, userId);
    }
}
