package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.SpecialPost;
import com.aaa.hjd.vo.PageNumAndSize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/6/2
 */
@RestController
@Api(value = "特殊人员信息相关操作",tags = "特殊人员信息相关操作")
public class SpecialPostController {

    @Autowired
    private PubService pubService;

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
    @ApiOperation(value = "获取当前用户下特殊人员信息")
    public ResultData getSpecialPost(@RequestBody PageNumAndSize pageNumAndSize) {
        return pubService.getSpecialPost(pageNumAndSize);
    }


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
    @ApiOperation(value = "根据userid单位特殊人员信息")
    public ResultData getSpecialPostByUserId(@RequestBody HashMap map) {
        return pubService.getSpecialPostByUserId(map);
    }

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
    @ApiOperation(value = "新增特殊人员信息")
    public ResultData addSpecialPost (@RequestBody SpecialPost specialPost){
        return pubService.addSpecialPost(specialPost);
    }

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
    @ApiOperation(value = "更新特殊人员信息")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost){
        return pubService.updateSpecialPost(specialPost);
    }

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
    @ApiOperation(value = "删除特殊人员信息id数组")
    public ResultData deleteSpecialPostByIDs(@RequestBody List<Object> ids){
        return pubService.deleteSpecialPostByIDs(ids);
    }
}
