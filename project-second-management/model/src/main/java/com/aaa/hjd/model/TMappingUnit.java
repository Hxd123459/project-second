package com.aaa.hjd.model;

import com.aaa.hjd.base.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 测绘单位表(TMappingUnit)实体类
 *
 * @author makejava
 * @since 2020-05-19 14:13:24
 */
@Data
public class TMappingUnit extends BaseModel implements Serializable {
    private static final long serialVersionUID = 553845369324883601L;
    /**
    * 备注
    */
    private String memo;
    /**
    * 单位名称
    */
    private String unitName;
    /**
    * 注册地址
    */
    private String registerAddress;
    /**
    * 注册时间
    */
    private Object registerTime;
    /**
    * 办公地址
    */
    private String oa;
    /**
    * 法人
    */
    private String corporation;
    /**
    * 联系人
    */
    private String linkman;
    /**
    * 所属行政区
    */
    private String ownedDistrict;
    /**
    * 注册资金(万元)
    */
    private Object registerFund;
    /**
    * 统一社会信用代码
    */
    private String socialCreditCode;
    /**
    * 资质等级
    */
    private String qualificationLevel;
    /**
    * 联系电话
    */
    private String phone;
    /**
    * 联系方式
    */
    private String contactWay;
    /**
    * 业务范围
    */
    private String businessScope;
    /**
    * 单位简介
    */
    private String unitIntro;
    /**
    * 单位曾用名
    */
    private String usedName;
    /**
    * 注册地址经度
    */
    private String registerAddressLon;
    /**
    * 注册单位纬度
    */
    private String registerAddressLat;
    /**
    * 注册地址邮编
    */
    private String registerAddressPostcode;
    /**
    * 办公地址邮编
    */
    private String oaPostcode;
    /**
    * 办公场所面积（平方米）
    */
    private Object oaArea;
    /**
    * 单位成立时间
    */
    private Object establishTime;
    /**
    * 手机号码
    */
    private String mobilePhone;
    /**
    * 传真号码
    */
    private String faxNum;
    /**
    * 电子邮箱
    */
    private String email;
    /**
    * 测绘人员总数
    */
    private Integer surveyingNum;
    /**
    * 职工总数
    */
    private Integer staffNum;
    /**
    * 单位性质
    */
    private String unitNature;
    /**
    * 所属行业
    */
    private String belongIndustry;
    /**
    * 证书编号
    */
    private String certificateCode;
    /**
    * 发证日期
    */
    private Object certificateSendDate;
    /**
    * 公司类型
    */
    private String companyType;
    /**
    * 股东及控股情况
    */
    private String stockDetails;
    /**
    * 合资形式
    */
    private String jointVenture;
    /**
    * 合资企业中方控股（%）
    */
    private Integer jointChP;
    /**
    * 合资企业批注文号
    */
    private String jointRatifyCode;
    /**
    * 主管部门
    */
    private String competentDepart;
    /**
    * 首次取得资质等级
    */
    private String firstQualificationLevel;
    /**
    * 首次取得资质发证日期
    */
    private Object firstQualificationDate;
    /**
    * 申请资质前单位进行过程
    */
    private String qualificationProcess;
    /**
    * 组织机构代码
    */
    private String organizationCode;
    /**
    * 单位直属类型
    */
    private String unitType;
    /**
    * 单位用户编号
    */
    private Object userId;
    /**
    * 单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
    */
    private Integer auditStatus;
    /**
    * 坐标
    */
    private Object coordinate;
    /**
    * 
单位代码
    */
    private String unitCode;
    /**
    * 1白名单2
黑名单3待定
    */
    private Integer unitStatus;
    /**
    * 同步状态 0：已同步 1：未同步
    */
    private Integer synchronizationStatus;
    /**
    * 单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
    */
    private Integer score;
    /**
    * 备案业务分类: 不动产测绘和联合测绘
    */
    private String filingBusiness;
}