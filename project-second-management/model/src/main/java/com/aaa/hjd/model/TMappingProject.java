package com.aaa.hjd.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 测绘项目信息(TMappingProject)实体类
 *
 * @author makejava
 * @since 2020-05-25 23:09:07
 */
public class TMappingProject implements Serializable {
    private static final long serialVersionUID = -77568083276514067L;
    
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


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Object getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(Object projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getAcceptanceDepartment() {
        return acceptanceDepartment;
    }

    public void setAcceptanceDepartment(String acceptanceDepartment) {
        this.acceptanceDepartment = acceptanceDepartment;
    }

    public String getAcceptanceReport() {
        return acceptanceReport;
    }

    public void setAcceptanceReport(String acceptanceReport) {
        this.acceptanceReport = acceptanceReport;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public Object getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(Object projectArea) {
        this.projectArea = projectArea;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public String getAwardsDepartment() {
        return awardsDepartment;
    }

    public void setAwardsDepartment(String awardsDepartment) {
        this.awardsDepartment = awardsDepartment;
    }

    public String getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel;
    }

    public String getProjectQualityApproval() {
        return projectQualityApproval;
    }

    public void setProjectQualityApproval(String projectQualityApproval) {
        this.projectQualityApproval = projectQualityApproval;
    }

    public Object getWinningTime() {
        return winningTime;
    }

    public void setWinningTime(Object winningTime) {
        this.winningTime = winningTime;
    }

    public Object getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(Object acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    public String getBasicContent() {
        return basicContent;
    }

    public void setBasicContent(String basicContent) {
        this.basicContent = basicContent;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getResultsStatus() {
        return resultsStatus;
    }

    public void setResultsStatus(Integer resultsStatus) {
        this.resultsStatus = resultsStatus;
    }

    public Object getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Object coordinate) {
        this.coordinate = coordinate;
    }

    public String getMeridian() {
        return meridian;
    }

    public void setMeridian(String meridian) {
        this.meridian = meridian;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public String getManagementLevel() {
        return managementLevel;
    }

    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public String getEntrustUnit() {
        return entrustUnit;
    }

    public void setEntrustUnit(String entrustUnit) {
        this.entrustUnit = entrustUnit;
    }

    public String getAcceptUnit() {
        return acceptUnit;
    }

    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Integer getSynchronizationStatus() {
        return synchronizationStatus;
    }

    public void setSynchronizationStatus(Integer synchronizationStatus) {
        this.synchronizationStatus = synchronizationStatus;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

}