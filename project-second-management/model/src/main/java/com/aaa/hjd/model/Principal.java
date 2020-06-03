package com.aaa.hjd.model;

import com.aaa.hjd.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 单位负责人信息
 */
@Table(name = "`t_principal`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Principal extends BaseModel {

    /**
     * 负责人类别
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 证件类型
     */
    @Column(name = "`id_type`")
    private String idType;

    /**
     * 证件号码
     */
    @Column(name = "`id_number`")
    private String idNumber;

    /**
     * 年龄
     */
    @Column(name = "`age`")
    private Integer age;

    /**
     * 性别 0:女 1:男 2:保密
     */
    @Column(name = "`sex`")
    private Integer sex;

    /**
     * 工作年限
     */
    @Column(name = "`work_year`")
    private Integer workYear;

    /**
     * 职务
     */
    @Column(name = "`duty`")
    private String duty;

    /**
     * 职称
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 从事测绘工作年限
     */
    @Column(name = "`mapping_year`")
    private Integer mappingYear;

    /**
     * 学历专业
     */
    @Column(name = "`major`")
    private String major;

    /**
     * 单位用户编号
     */
    @Column(name = "`user_id`")
    private Long userId;
}