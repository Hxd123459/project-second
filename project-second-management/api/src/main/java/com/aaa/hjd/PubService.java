package com.aaa.hjd;

import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.*;
import com.aaa.hjd.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 13:11
 * Description:
 * fallbackFactory:就是来实现熔断的，在实际开发中，开发阶段不能去开启熔断
 * 因为一旦开启了熔断，整个异常都不会再抛出，不方便调bug
 * 实际开发必须注意的东西:
 * 无论是springcloud1.x还是2.x版本
 * 一旦使用feign来进行传递参数的时候，必须要注意两个点:
 * 1.如果是简单类型(8种基本类型，String)--->必须使用注解@RequestParam
 *   基本类型可以传多个，也就是说一个方法的参数中可以使用多@RequestParam
 * 2.如果传递包装类型(List, Map, Vo, Po),只能传递一个，而且必须要使用@RequestBody注解
 *   也就是说最终把这些参数值传递到provider项目的controller中，
 *   在这provider项目的controller中也必须使用,相同的注解，而且provider和api的方法必须要一模一样(copy是最方便的)
 */
@FeignClient(value = "system-interface")
public interface PubService {
    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody TUser user);

    /**
     * 查询所有的单位
     * @param tokenVo
     * @return
     */
    @ResponseBody
    @PostMapping("/getSurveyingUnits")
    ResultData selectAllSurveyingUnits(@RequestBody  TokenVo tokenVo);

    /**
     * 当用户需要进行登录时，引导前端跳转到登陆界面
     * @return
     */
    @RequestMapping("/turnLogin")
    TokenVo turnLogin();

    /**
     * 查询菜单信息
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/getAllMenus")
    ResultData getAllMenus(@RequestBody TMenu tMenu);

    /**
     * 新增菜单或者是按钮
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/addMenuOrButton")
    ResultData addMenuOrButton(@RequestBody TMenu tMenu);

    /**
     * 删除菜单或者是按钮根据id
     * @param ids 目标id
     * @return
     */
    @ResponseBody
    @PostMapping("/delMenuOrButton")
    ResultData delMenuOrButton(@RequestBody List<Object> ids);

    /**
     * 更新菜单或者是按钮
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/updateMenuOrButton")
    ResultData updateMenuOrButton(@RequestBody TMenu tMenu);

    /**
     * 通过id查询一条菜单或者是按钮信息
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/selectMenuOrButtonById")
    ResultData selectMenuOrButtonById(@RequestBody TMenu tMenu);


    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有用户信息带分页
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @PostMapping("/getUserAll")
    public ResultData getUserAll(@RequestBody HashMap<String, Integer> map);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有角色
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("/getRoleAll")
    public ResultData getRoleAll();

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据id获取用户的所有角色
     * @param [id]
     * @return java.util.List<java.lang.Long>
     * @throws
     */
    @GetMapping("/getUserRoleByID")
    public ResultData getUserRoleByID(@RequestParam("id") Long id);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据ids删除所有用户
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @DeleteMapping("/deleteUserByIDs")
    public ResultData deleteUserByIDs (@RequestBody List<Object> ids);

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据用户id修改用户信息
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @PostMapping("/updataUserByID")
    public ResultData updataUserByID (@RequestBody UpdateUserVo updataUserVo);

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 新增用户
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PutMapping("/addUser")
    public ResultData addUser(@RequestBody UpdateUserVo updataUserVo);

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 获取部门层级列表
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getDeptName")
    public ResultData getDeptName();

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表状态值
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserStatus")
    public ResultData getUserStatus();

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表性别
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserSsex")
    public ResultData getUserSsex();

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息，自动获取当前用户id
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getMappingUnit")
    ResultData getMappingUnit();


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
    ResultData getMappingUnitByUserId(@RequestParam("userId")Long userId);


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
    ResultData updateMappingUnit(@RequestBody TMappingUnit tMappingUnit);

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取设备信息--分页
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getEquipment")
    public ResultData getEquipment(@RequestBody PageNumAndSize pageNumAndSize);

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取设备信息--分页
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getEquipmentByUserId")
    public ResultData getEquipmentByUserId(@RequestBody HashMap map);

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 根据id数组删除设备信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deleteEquipmentByIDs")
    ResultData deleteEquipmentByIDs(@RequestBody List<Object> ids);


    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("insertEquipment")
    ResultData insertEquipment(@RequestBody Equipment equipment);
    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 修改设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updateEquipment")
    ResultData updateEquipment(@RequestBody Equipment equipment);


    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取单位负责人信息
     * 需要自己获取到当前登录用户的id
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    @PostMapping("/getPrincipal")
    ResultData getPrincipal(@RequestBody PageNumAndSize pageNumAndSize);


    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取单位负责人信息
     * 需要自己获取到当前登录用户的id
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    @PostMapping("/getPrincipalByUserId")
    ResultData getPrincipalByUserId(@RequestBody HashMap map);
    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增单位负责人信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("addPrincipal")
    ResultData addPrincipal (@RequestBody Principal principal);


    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 修改负责人信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updatePrincipal")
    ResultData updatePrincipal(@RequestBody Principal principal);

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 删除负责人信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deletePrincipals")
    ResultData deletePrincipals(@RequestBody List ids);

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 查询单位负责人附件信息
     * @param
     * @return
     * @throws
     */
    @PostMapping("/getPrincipalResource")
    ResultData getPrincipalResource(@RequestParam("principalId") Long principalId);

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取特殊人员信息，自动获取当前登录的用户id
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getSpecialPost")
    ResultData getSpecialPost(@RequestBody PageNumAndSize pageNumAndSize);


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
    ResultData getSpecialPostByUserId(@RequestBody HashMap map);

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
    ResultData addSpecialPost (@RequestBody SpecialPost specialPost);

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
    ResultData updateSpecialPost(@RequestBody SpecialPost specialPost);

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
    ResultData deleteSpecialPostByIDs(@RequestBody List<Object> ids);


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
    ResultData getTechnicist(@RequestBody PageNumAndSize pageNumAndSize);

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
    ResultData getTechnicistByUserId(@RequestBody HashMap map);
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
    ResultData deleteTechnicistByIDs(@RequestBody List<Object> ids);

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
    ResultData insertTechnicist(@RequestBody Technicist technicist);

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
    ResultData updateTechnicist(@RequestBody Technicist technicist);

    /**
     * 获取指定用户的项目信息，带有分页
     * @param mappingProjectPageVo
     * @return
     */
    @PostMapping(value = "/getMappingProjectByPage")
    ResultData getMappingProjectByPage(@RequestBody TMappingProjectPageVo mappingProjectPageVo);

    /**
     * 添加项目信息
     * @param fileOfRangeLine2
     * @param fileOfRangeLine3
     * @param fileOfContract
     * @param fileOfContract2
     * @param fileOfContract3
     * @param coordinateSystem
     * @param meridian
     * @param projectType
     * @param managementLevel
     * @param fundingSource
     * @param projectName
     * @param heightDatum
     * @param entrustUnit
     * @param acceptUnit
     * @param projectAmount
     * @param projectLeader
     * @param mobilePhone
     * @param phone
     * @param address
     * @param startDate
     * @param endDate
     * @param acceptanceDepartment
     * @param acceptanceReport
     * @param projectArea
     * @param scale
     * @param sheetNumber
     * @param awardsDepartment
     * @param prizeLevel
     * @param projectQualityApproval
     * @param winningTime
     * @param acceptanceTime
     * @param basicContent
     * @param creditStatus
     * @param submitStatus
     * @param userId
     * @return
     */
    @PostMapping(value = "/addMappingProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData addMappingProject(@RequestPart(value = "fileOfRangeLine",required = false)
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
                                 @RequestParam(value = "userId") Long userId);


    /**
     * 查询字典数据带分页，带条件查询
     * @param dictVo
     * @return
     */
    @PostMapping("/selectDictByPage")
    ResultData selectDictByPage(@RequestBody DictVo dictVo);

    /**
     * 通过id查询字典数据
     * @param tDict
     * @return
     */
    @PostMapping("/selectDictById")
    ResultData selectDictById(@RequestBody TDict tDict);

    /**
     * 通过id更新字典数据
     * @param dict
     * @return
     */
    @PostMapping("/updateDictById")
    ResultData updateDictById(@RequestBody TDict dict);

    /**
     * 添加字典信息
     * @param tDict
     * @return
     */
    @PostMapping("/addDict")
    ResultData addDict(@RequestBody TDict tDict);

    /**
     * 通过id批量删除字典数据
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchByIds")
    ResultData deleteBatchByIds(@RequestBody List<Object> ids);

    /**
     * @date:  2020/5/27
     * @author: 秀仔
     * @Description
     * 登录日志
     * @param [map]
     * @return com.aaa.zwc.base.ResultDate
     * @throws
     */
    @PostMapping("/addLoginLog")
    void addLoginLog(@RequestBody HashMap<String, Object> map);

}
