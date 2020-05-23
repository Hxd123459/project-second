package com.aaa.hjd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: xxf
 * @Time: Create in 2020/5/23  14:15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeptVo implements Serializable {

    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
