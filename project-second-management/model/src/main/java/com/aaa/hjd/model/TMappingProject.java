package com.aaa.hjd.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 测绘项目信息(TMappingProject)实体类
 *
 * @author makejava
 * @since 2020-06-03 22:55:55
 */
public class TMappingProject implements Serializable {
    private static final long serialVersionUID = -95345754804543480L;
    
    private Object id;
    /**
    * 项目类型
    */
    private String projectType;
    /**
    * 项目名称
    */
    private String projectName;
    /**
    * 项目金额（万元）
    */
    private Object projectAmount;
    /**
    * 项目负责人
    */
    private String projectLeader;
    /**
    * 开工日期
    */
    private Object startDate;
    /**
    * 完工日期
    */
    private Object endDate;
    /**
    * 完成工期
    */
    private String completeTime;
    /**
    * 验收机构
    */
    private String acceptanceDepartment;
    /**
    * 验收报告文号
    */
    private String acceptanceReport;
    /**
    * 任务来源
    */
    private String taskSource;
    /**
    * 项目面积（km²）
    */
    private Object projectArea;
    /**
    * 比例尺（开本，册）
    */
    private String scale;
    /**
    * 图幅数量（线路里程）
    */
    private String sheetNumber;
    /**
    * 颁奖单位
    */
    private String awardsDepartment;
    /**
    * 获奖类型等级
    */
    private String prizeLevel;
    /**
    * 项目质量认可
    */
    private String projectQualityApproval;
    /**
    * 获奖时间
    */
    private Object winningTime;
    /**
    * 验收时间
    */
    private Object acceptanceTime;
    /**
    * 基本内容
    */
    private String basicContent;
    /**
    * 履约情况
    */
    private String creditStatus;
    /**
    * 向测绘主管部门汇交成果情况
    */
    private String submitStatus;
    /**
    * 单位用户编号
    */
    private Long userId;
    /**
    * 进度（百分比）
    */
    private Integer schedule;
    /**
    * 创建时间
    */
    private Object createTime;
    /**
    * 更改时间
    */
    private Object modifyTime;
    /**
    * 备注
    */
    private String memo;
    /**
    * 项目进行状态 2:未完成 3:已完成
    */
    private Integer status;
    /**
    * 项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
    */
    private Integer auditStatus;
    /**
    * 项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
    */
    private Integer resultsStatus;
    /**
    * 坐标
    */
    private Object coordinate;
    /**
    * 中央子午线
    */
    private String meridian;
    /**
    * 坐标系
    */
    private String coordinateSystem;
    /**
    * 管理级别
    */
    private String managementLevel;
    /**
    * 资金来源
    */
    private String fundingSource;
    /**
    * 
委托单位
    */
    private String entrustUnit;
    /**
    * 
承建单位
    */
    private String acceptUnit;
    /**
    * 手机号码
    */
    private String mobilePhone;
    /**
    * 固定
电话
    */
    private String phone;
    /**
    * 项目所在地
    */
    private String address;
    /**
    * 项目中心点
    */
    private String centerPoint;
    /**
    * 同步状态 0：已同步 1：未同步
    */
    private Integer synchronizationStatus;
    /**
    * 合同上传时间
    */
    private Date contractTime;


}