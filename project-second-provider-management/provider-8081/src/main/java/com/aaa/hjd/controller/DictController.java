package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TDict;
import com.aaa.hjd.service.TDictService;
import com.aaa.hjd.vo.DictVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/4 0004
 * Time: 0:47
 * Description:
 */
@RestController
public class DictController extends CommonController<TDict> {
    @Autowired
    private TDictService tDictService;

    @Override
    public BaseService<TDict> getBaseService() {
        return tDictService;
    }

    @PostMapping("/selectDictByPage")
    public ResultData selectDictByPage(@RequestBody DictVo dictVo){
        try {
            PageInfo<TDict> tDictPageInfo = tDictService.selectDictByPage(dictVo);
            if (tDictPageInfo.getList().size()>0&&tDictPageInfo!=null) {
                return selectSuccess(tDictPageInfo);
            }else {
                ResultData resultData = new ResultData();
                resultData.setCode("20000");
                resultData.setMsg("暂无数据");
                return resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }

    @PostMapping("/selectDictById")
    public ResultData selectDictById(@RequestBody TDict tDict){
        try {
            TDict tDict1 = tDictService.selectDictById(tDict);
            if (null!=tDict1) {
                return selectSuccess(tDict1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }

    @PostMapping("/updateDictById")
    public ResultData updateDictById(@RequestBody TDict dict){
        try {
            Integer integer = tDictService.updateDictById(dict);
            if (1==integer) {
                return updateDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateDataFailed();
    }

    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody TDict tDict){
        try {
            Integer integer = tDictService.addDict(tDict);
            if (1==integer) {
                return addDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addDataFailed();
    }

    @PostMapping("/deleteBatchByIds")
    public ResultData deleteBatchByIds(@RequestBody List<Object> ids){
        try {
            Integer integer = tDictService.deleteBatchByIds(ids);
            if (ids.size()==integer){
                return delDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delDataFailed();
    }
}
