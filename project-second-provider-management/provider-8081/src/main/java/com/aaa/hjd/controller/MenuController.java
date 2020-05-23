package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMenu;
import com.aaa.hjd.service.MenuService;
import com.aaa.hjd.utils.JSONUtil;
import com.aaa.hjd.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.aaa.hjd.status.StatusCodeAndMsg.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/20 0020
 * Time: 23:57
 * Description:
 */
@Controller
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;
    @ResponseBody
    @PostMapping("/getAllMenus")
    public ResultData getAllMenus(@RequestBody TMenu tMenu){
        ResultData resultData = new ResultData();
        List<TMenu> menus = menuService.selectAllMenus(tMenu);
        if (null!=menus && menus.size()>0) {
            //说明查询到数据了
            resultData.setMsg(GET_MENU_SUCCESS.getMsg());
            resultData.setCode(GET_MENU_SUCCESS.getCode());
            resultData.setData(menus);
        }else {
            //说明没有查询到数据
            resultData.setMsg(GET_MENU_FAILED.getMsg());
            resultData.setCode(GET_MENU_FAILED.getCode());
        }
        return resultData;
    }

    @ResponseBody
    @PostMapping("/addMenuOrButton")
    public ResultData addMenuOrButton(@RequestBody TMenu tMenu){
        Integer add = menuService.addMenusOrButton(tMenu);
        if (add==1) {
            //说明新增成功
            return addDataSuccess();
        }else {
            return addDataFailed();
        }
    }

    @ResponseBody
    @PostMapping("/delMenuOrButton")
    public ResultData delMenuOrButton(@RequestBody List<Object> ids){
        if (ids.size()>0&&null!=ids) {
            Integer delOfResult = null;
            try {
                delOfResult = menuService.delMenusOrButton(ids);
                if (delOfResult==ids.size()) {
                    //说明全部删除成功
                    return delDataSuccess();
                }else {
                    return delDataFailed();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody TMenu tMenu){

        Integer updateOfResult = menuService.updateMenuOrButton(tMenu);
        if (updateOfResult==1&&null!=updateOfResult) {
            //说明跟新成功
            return updateDataSuccess();
        }else {
            return updateDataFailed();
        }
    }

    @ResponseBody
    @PostMapping("/selectMenuOrButtonById")
    public ResultData selectMenuOrButtonById(@RequestBody TMenu tMenu){
        TMenu selectOfResult = menuService.selectTMenuByPrimaryKey(tMenu);
        if (null!=selectOfResult) {
            //说明查询成功
            return selectSuccess(selectOfResult);
        }else {
            return selectFailed();
        }
    }

}
