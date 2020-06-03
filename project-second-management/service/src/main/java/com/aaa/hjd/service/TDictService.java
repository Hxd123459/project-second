package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.TDictMapper;
import com.aaa.hjd.model.TDict;
import com.aaa.hjd.vo.DictVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/4 0004
 * Time: 0:12
 * Description:
 */
@Service
public class TDictService extends BaseService<TDict> {
    @Autowired
    private TDictMapper tDictMapper;
    /**
     * 查询字典数据、带分页、带条件查询
     * @param dictVo
     * @return
     */
  public PageInfo<TDict> selectDictByPage(DictVo dictVo) throws Exception {
      if (dictVo.getPageNum()==null){
          dictVo.setPageNum(1);
      }
      if (dictVo.getPageSize()==null){
          dictVo.setPageSize(10);
      }
      PageInfo<TDict> tDictPageInfo = super.queryListPage(dictVo.getDict(), dictVo.getPageNum(), dictVo.getPageSize());
     return tDictPageInfo;
  }

    /**
     * 根据id查询字典信息
     * @param TDict
     * @return
     */
  public TDict selectDictById(TDict tDict) throws Exception {
      TDict tDict1 = super.queryOne(tDict);
      return tDict1;
  }

    /**
     * 根据id修改字典信息
     * @param tDict
     * @return
     * @throws Exception
     */
  public Integer updateDictById(TDict tDict) throws Exception {
      Integer update = super.update(tDict);
      return update;
  }

    /**
     * 添加字典信息
     * @param tDict
     * @return
     * @throws Exception
     */
  public Integer addDict(TDict tDict) throws Exception {
      Integer add = super.add(tDict);
      return add;
  }

    /**
     * 根据id批量删除字典信息
     * @param ids
     * @return
     * @throws Exception
     */
  public Integer deleteBatchByIds(List<Object> ids) throws Exception {
      Integer integer = tDictMapper.deleteBatchById(ids);
      return integer;
  }
}
