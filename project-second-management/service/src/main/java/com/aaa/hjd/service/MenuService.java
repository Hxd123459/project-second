package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.TMenuMapper;
import com.aaa.hjd.model.TMenu;
import com.aaa.hjd.utils.JSONUtil;
import com.aaa.hjd.utils.Map2BeanUtils;
import com.aaa.hjd.utils.TimeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.aaa.hjd.status.StatusCodeAndMsg.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/20 0020
 * Time: 23:37
 * Description:
 *
 *  List<TMenu> menus = tMenuMapper.select(tMenu);
 *         for (TMenu menu:
 *                 menus) {
 *
 *             tMenu.setParentId(menu.getMenuId());
 *             menu.setSubmenu(selectAllMenus(menu1));
 *         }
 *         if (menus.size()==0){
 *             return null;
 *         }
 *         return menus;
 */
@Service
public class MenuService extends BaseService<TMenu> {
    @Autowired
    private TMenuMapper tMenuMapper;

    /**
     * 获取菜单信息
     * @return
     */
    public List<TMenu> selectAllMenus(TMenu tMenu){
        List<TMenu> menus = tMenuMapper.selectMenuByParenId(tMenu);
        //递归结束的条件-就是子菜单下面再无子菜单
        if (menus.size()>0&&null!=menus) {
            for (TMenu menu:menus) {
                //将上级菜单的id，作为parentId在此进行查询
                tMenu.setParentId(menu.getId());
                //递归调用，查询出上级菜单的子菜单
                List<TMenu> subMenu = selectAllMenus(tMenu);
                //将和上级菜单对应的子菜单放到上级菜单的subMenus属性中
                menu.setSubmenu(subMenu);
            }
        }
        return menus;
    }


    /**
     * 添加菜单/按钮
     * @param tMenu 菜单/按钮的信息
     * @return
     */
   public Integer addMenusOrButton(TMenu tMenu){
       String nowTimeYMDHMS = TimeUtils.getNowTimeYMDHMS();
       tMenu.setCreateTime(nowTimeYMDHMS);
       try {
           Integer addOfResult = super.add(tMenu);
           return addOfResult;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 删除菜单或者是按钮
     * @param ids 要删除的用户的id
     *            super.batchDeleteByPrimaryKey(ids);
     * @return
     * @Exception
     */
   @Transactional(rollbackFor = Exception.class)
   public Integer delMenusOrButton(List<Object> ids) throws Exception{
       Integer delOfResult = tMenuMapper.batchDelMenuOrButton(ids);
       System.out.println("delOfResult"+delOfResult);
       return delOfResult;
   }

    /**
     * 更新改单或者
     * @param tMenu
     * @return
     */
   public Integer updateMenuOrButton(TMenu tMenu){
       String s = TimeUtils.toStringTimeYMDHMS(new Date());
       tMenu.setModifyTime(s);
       try {

           Integer updateOfResult = super.update(tMenu);
           System.out.println("updateOfResult="+updateOfResult);

           return updateOfResult;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }

    /**
     * 查询一条菜单或者按钮信息
     * @param tMenu
     * @return
     */
   public TMenu selectTMenuByPrimaryKey(TMenu tMenu){
       try {
           TMenu selectOfResult = super.queryOne(tMenu);
           return selectOfResult;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }
}

