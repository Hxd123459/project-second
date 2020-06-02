package com.aaa.hjd.model.entity;

import java.io.Serializable;

/**
 * 附件表(TResource)实体类
 *
 * @author makejava
 * @since 2020-05-26 20:33:33
 */
public class TResource implements Serializable {
    private static final long serialVersionUID = 607810385863747196L;
    /**
    * 编号
    */
    private Object id;
    /**
    * 资源名称
    */
    private String name;
    /**
    * 资源大小
    */
    private Long size;
    /**
    * 资源路径
    */
    private String path;
    /**
    * 资源文件类型
    */
    private String type;
    /**
    * 资源后缀名
    */
    private String extName;
    /**
    * 文件业务类型
    */
    private String refBizType;
    /**
    * 文件关联编号
    */
    private Long refBizId;
    /**
    * 创建时间
    */
    private Object createTime;
    /**
    * 修改时间
    */
    private Object modifyTime;
    /**
    * 备注
    */
    private String memo;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getRefBizType() {
        return refBizType;
    }

    public void setRefBizType(String refBizType) {
        this.refBizType = refBizType;
    }

    public Long getRefBizId() {
        return refBizId;
    }

    public void setRefBizId(Long refBizId) {
        this.refBizId = refBizId;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Object modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}