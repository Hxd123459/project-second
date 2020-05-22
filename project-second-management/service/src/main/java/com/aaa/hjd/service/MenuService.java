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
 *             TMenu menu1 = new TMenu();
 *             menu1.setParentId(menu.getMenuId());
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
    public List<TMenu> selectAllMenus(){
        //菜单树
        List<TMenu> menusList=new ArrayList<TMenu>();
        //菜单的全部信息
        List<TMenu> allMenusList=tMenuMapper.selectAll();
        if (null!=allMenusList&&allMenusList.size()>0) {
            //拿到一级菜单信息
            for (int i = 0; i <allMenusList.size() ; i++) {
                TMenu menu = allMenusList.get(i);
                if (menu.getParentId()==0) {
                    //说明是一级菜单
                    menusList.add(menu);
                }
            }
            //为一级菜单设置子菜单
            for (TMenu menu: menusList) {
               menu.setSubmenu(getSubMenu(menu.getId(),allMenusList));
            }
        }

        return menusList;
    }

    /**
     * 获取上一级菜单的子菜单
     * @param menuId 上一级菜单的id
     * @param allMenus 所有的菜单信息（包含一级，二级，三级）
     * @return
     */
    private List<TMenu> getSubMenu(Long menuId,List<TMenu> allMenus){
        //子菜单
        List<TMenu> subMenus=new ArrayList<TMenu>();
        for (TMenu menu:
             allMenus) {
            if (menu.getParentId().equals(menuId)){
                subMenus.add(menu);
            }
        }
        //子菜单的下一级
        //疑问：当递归进入，查找子菜单的子菜单，那么子菜单的数据现在在哪，是在下面循环代码中的subMenus中
        for (TMenu menu:
             subMenus) {
             menu.setSubmenu(getSubMenu(menu.getId(),allMenus));
        }
        if (subMenus.size()==0){
            return null;
        }
        return subMenus;
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

