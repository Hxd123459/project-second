package com.aaa.hjd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/3 0003
 * Time: 13:28
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_resource")
public class Resource implements Serializable {
    private static final long serialVersionUID = 607810385863747196L;
    /**
     * 编号
     */
    private Long id;
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
    private String createTime;
    /**
     * 修改时间
     */
    private String modifyTime;
    /**
     * 备注
     */
    private String memo;



}