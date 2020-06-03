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
 * 仪器设备信息
 */
@Table(name = "`t_equipment`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Equipment extends BaseModel {

    /**
     * 仪器设备名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 品牌型号
     */
    @Column(name = "`brand`")
    private String brand;

    /**
     * 出厂编号
     */
    @Column(name = "`production_id`")
    private String productionId;

    /**
     * 数量
     */
    @Column(name = "`number`")
    private Integer number;

    /**
     * 检定日期
     */
    @Column(name = "`check_date`")
    private Date checkDate;

    /**
     * 检定有效日期
     */
    @Column(name = "`effective_date`")
    private Date effectiveDate;

    /**
     * 发票代码
     */
    @Column(name = "`invoice_code`")
    private String invoiceCode;

    /**
     * 检定机构
     */
    @Column(name = "`check_department`")
    private String checkDepartment;

    /**
     * 检定证书号
     */
    @Column(name = "`check_certificate_id`")
    private String checkCertificateId;

    /**
     * 认定
     */
    @Column(name = "`identified`")
    private String identified;

    /**
     * 单位用户编号
     */
    @Column(name = "`user_id`")
    private Long userId;
}