package com.aaa.hjd.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.util.Sqls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/12 0012
 * Time: 20:55
 * Description:
 */
public abstract class CommonController<T> extends BaseController {
    /**
     * 钩子函数，在新增之前所执行的内容
     * @param map
     */
    protected void beforeAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }
    /**
     * 钩子函数，在新增之后所执行的内容
     * @param map
     */
    protected void afterAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }

    /**
     * 定义获取BaseService的抽象方法
     * @return
     */
    public abstract BaseService<T> getBaseService();

    /**
     * 新增数据
     * @param map
     * @return
     */
    public ResultData add(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().add(instance);
            if (insertResult>0) {
                //说明保存成功
                afterAdd(map);
                return addDataSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return addDataFailed();
    }

    /**
     * 删除数据
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer integer = getBaseService().deleteByPrimaryKey(instance);
            if (integer>0) {
                //删除成功
                afterAdd(map);
                return delDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delDataFailed();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ResultData batchDelete(List<Object> ids){
        try {
            Integer integer = getBaseService().batchDeleteByPrimaryKey(ids);
            if (integer>0) {
                //批量删除成功
                return delDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delDataFailed();
    }

    // TODO  getListByPage()

    /**
     * 更新数据
     * @param map
     * @return
     */
    public ResultData update(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer update = getBaseService().update(instance);
            if (update>0) {
                //更新成功
                return updateDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateDataFailed();
    }

    /**
     * 查询一条数据
     * @param map
     * @return
     */
    public ResultData getOne(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            T selectOneResult = getBaseService().queryOne(instance);
            if (null!=selectOneResult) {
                //查询成功
               return new ResultData("20006","查询成功",selectOneResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData("10010","无数据",null);
    }

    /**
     * 查询多条数据无条件
     * @param map
     * @return
     */
    public ResultData getList(@RequestBody Map map){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            List<T> ts = getBaseService().queryList(instance);
            if (ts.size()>0) {
                //查询到数据
                return new ResultData("20007","查询成功",ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData("10011","无数据",null);
    }

    /**
     * 不带条件的分页查询
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ResultData getListByPage(@RequestBody Map map,Integer pageNo,Integer pageSize){
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            PageInfo<T> tPageInfo = getBaseService().queryListPage(instance, pageNo, pageSize);
            if (tPageInfo.getSize()>0) {
                //查询到数据
                return new ResultData("20008","查询成功",tPageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData("10012","查询成功",null);
    }

    public ResultData getListByFields(){
        return null;
    }

    /**
     *   防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     *   必须要从本地当前线程中获取对象
     * @return
     */
   public HttpServletRequest getServletRequest(){
       RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
       ServletRequestAttributes servletRequestAttributes;
       if (requestAttributes instanceof ServletRequestAttributes) {
           servletRequestAttributes=(ServletRequestAttributes)requestAttributes;
           return servletRequestAttributes.getRequest();
       }
       return null;
   }

    /**
     * 获取当前客户端的session对象(如果不存在，则会重新创建一个)
     * @return
     */
   public HttpSession getSession(){
       return getServletRequest().getSession();
   }

    /**
     * 获取当前客户端的session对象(如果不存在，则直接返回null)
     * @return
     */
   public HttpSession getExistSession(){
       return getServletRequest().getSession(false);
   }

}
