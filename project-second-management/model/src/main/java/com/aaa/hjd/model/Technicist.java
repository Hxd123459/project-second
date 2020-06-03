package com.aaa.hjd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 技术人员信息
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Table(name = "`t_technicist`")
public class Technicist implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "`id`")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 计入专业技术人员类别
     */
    @Column(name = "`major_type`")
    private String majorType;

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
     * 性别 0:女 1:男 2:保密
     */
    @Column(name = "`sex`")
    private Integer sex;

    /**
     * 年龄
     */
    @Column(name = "`age`")
    private Integer age;

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
     * 毕业院校
     */
    @Column(name = "`school`")
    private String school;

    /**
     * 毕业时间
     */
    @Column(name = "`graduation_date`")
    private String graduationDate;

    /**
     * 学位
     */
    @Column(name = "`degree`")
    private String degree;

    /**
     * 学历
     */
    @Column(name = "`education_background`")
    private String educationBackground;

    /**
     * 所学专业
     */
    @Column(name = "`major`")
    private String major;

    /**
     * 职称专业
     */
    @Column(name = "`title_major`")
    private String titleMajor;

    /**
     * 进入本单位时间
     */
    @Column(name = "`start_time`")
    private String startTime;

    /**
     * 任职时间(获得职称时间)
     */
    @Column(name = "`title_time`")
    private String titleTime;

    /**
     * 聘用或劳动合同开始时间
     */
    @Column(name = "`start_contract`")
    private String startContract;

    /**
     * 聘用或劳动合同终止时间
     */
    @Column(name = "`end_contract`")
    private String endContract;

    /**
     * 现从事工作
     */
    @Column(name = "`post`")
    private String post;

    /**
     * 从事测绘工作年限
     */
    @Column(name = "`mapping_year`")
    private Integer mappingYear;

    /**
     * 特殊岗位
     */
    @Column(name = "`special_post`")
    private String specialPost;

    /**
     * 认定
     */
    @Column(name = "`affirm`")
    private String affirm;

    /**
     * 单位用户编号
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private String modifyTime;
}