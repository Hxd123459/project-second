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
 * 特殊岗位人员信息
 */
@Table(name = "`t_special_post`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SpecialPost extends BaseModel {


    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 有效证件号
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
     * 毕业院校
     */
    @Column(name = "`school`")
    private String school;

    /**
     * 所学专业
     */
    @Column(name = "`major`")
    private String major;

    /**
     * 学历
     */
    @Column(name = "`education_background`")
    private String educationBackground;

    /**
     * 学位
     */
    @Column(name = "`degree`")
    private String degree;

    /**
     * 特殊岗位
     */
    @Column(name = "`special_post`")
    private String specialPost;

    /**
     * 单位用户编号
     */
    @Column(name = "`user_id`")
    private Long userId;

}