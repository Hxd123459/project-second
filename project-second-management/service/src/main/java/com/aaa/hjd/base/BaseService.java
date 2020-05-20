package com.aaa.hjd.base;

import com.aaa.hjd.utils.Map2BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/11 0011
 * Time: 22:24
 * Description:
 */
public abstract class BaseService<T> {
    /**
     * 本地缓冲池
     * 也就是 将局部变量，缓存到本地，变为全局变量
     */
    private Class<T>  cache=null;

    @Autowired
    private Mapper<T> mapper;

    /**
     * 上面的Mapper为了安全性（防止越级操作），权限修饰符必须是private,
     *  那么他的子类（UserService）就调用不到，所以需要提供方法给子类用
     *  修饰符不能是public 不能被其它包调用，只能是当前包。
     * @return
     */
    protected Mapper getMapper(){
        return mapper;
    }

    /**
     * 新增功能
     * insert和insertSelective区别
     * insert：此方法使用所有的属性作为字段使用，无论该字段是不是null
     * insertSelective：使用不为null的属性作为字段使用
     * @param t
     * @return
     * @throws Exception
     */
    public Integer add(T t)throws Exception{
        return mapper.insertSelective(t);
    }

    /**
     * 通过主键删除数据
     * @param t
     * @return
     * @throws Exception
     */
    public Integer deleteByPrimaryKey(T t)throws Exception{
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 通过主键批量删除
     * Sqls.custom()自定义sql
     * andIn("id", ids) where 条件 id 是字段，ids是参数
     * @param ids
     * @return
     * @throws Exception
     */
    public Integer batchDeleteByPrimaryKey(List<Object> ids)throws Exception{
        Example example = Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * 更新功能
     * @param t
     * @return
     * @throws Exception
     */
    public Integer update(T t)throws Exception{
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 通过主键批量更新
     * @param t
     * @param ids
     * @return
     * @throws Exception
     */
    public Integer batchUpdate(T t,Object[] ids)throws Exception{
        Example example= Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /**
     * 查询一条数据
     * @param t
     * @return
     * @throws Exception
     */
    public T queryOne(T t)throws Exception{
        return mapper.selectOne(t);
    }

    /**
     * 通过指定字段查询一条数据
     * (有些表中有唯一键(username, iphone_num...))
     * @param where
     * @param orderByField
     * @param fields
     * @return
     * @throws Exception
     */
    public T queryByField(Sqls where,String orderByField,String... fields)throws Exception{
        return (T)queryByFilesBase(null,null,where,orderByField,fields).get(0);
    }

    /**
     * 条件查询集合
     * @param where
     * @param orderByField
     * @param fields
     * @return
     * @throws Exception
     */
    public List<T> queryListByFields(Sqls where,String orderByField,String... fields)throws Exception{
        return queryByFilesBase(null,null,where,orderByField,fields);
    }

    /**
     * 条件查询分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderByFields
     * @param fields
     * @return
     * @throws Exception
     */
    public PageInfo<T> queryListByPageAndFields(Integer pageNo,Integer pageSize,Sqls where,String orderByFields,String... fields)throws Exception{
        return new PageInfo<T>(queryByFilesBase(pageNo,pageSize,where,orderByFields,fields));
    }

    /**
     * 条件查询,查询多条
     * @param t
     * @return
     * @throws Exception
     */
    public List<T> queryList(T t)throws Exception{
        return mapper.select(t);
    }

    /**
     * 分页查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageInfo<T> queryListPage(T t,Integer pageNo,Integer pageSize)throws Exception{
        PageHelper.startPage(pageNo,pageSize);
        List<T> select=mapper.select(t);
        PageInfo<T> tPageInfo = new PageInfo<T>(select);;
        return tPageInfo;
    }

    /**
     * 根据反射获取实例对象
     * Map转bean对象
     * @param map
     * @return
     */
    protected T newInstance(Map map){
       return (T) Map2BeanUtils.map2Bean(map,getTypeArgument());
    }

    /**
     * 封装条件查询，分页查询以及排序查询的通用方法（多条件查询）
     * @param pageNo 第几页
     * @param pageSize 每页大小
     * @param where 查询条件
     * @param orderByField 排序
     * @param field 参数
     * @return
     */
    private List<T> queryByFilesBase(Integer pageNo,Integer pageSize,Sqls where,String orderByField,String... field){
        Example.Builder builder=null;
        if (null ==field || field.length==0){
          //没有条件查询，什么查询的是所有数据
            builder=Example.builder(getTypeArgument());
        }else {
            //指定某些/某个字段进行查询
            builder=Example.builder(getTypeArgument()).select(field);
        }
        if (null!=where) {
            builder=builder.where(where);
        }
        //排序规则
        if (null!=orderByField) {
            //这里就规定死，降序排序，如果还有添加，可以再添加个字段进行判断
            //是使用升序还是降序
            builder=builder.orderByDesc(orderByField);
        }
        //分页
        Example example=builder.build();
        if (null!=pageNo && null!=pageSize) {
            // pageHelper通用分页插件
            PageHelper.startPage(pageNo,pageSize);
        }
        List list = getMapper().selectByExample(example);
        return list;
    }

    /**
     * 获取子类泛型类型
     * this.getClass()拿到本类
     * getGenericSuperclass()拿到父类
     * getActualTypeArguments()参数类型
     * @return
     */
    private Class<T> getTypeArgument(){
        if (null!=cache) {
            cache=(Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }
}
