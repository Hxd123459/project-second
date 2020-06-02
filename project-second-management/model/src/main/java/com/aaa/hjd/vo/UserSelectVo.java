package com.aaa.hjd.vo;

import com.aaa.hjd.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserSelectVo{

    /**
     * 用户名
     */
    private String username;
    /**
     * 部门ID
     */
    private Long deptId;
;
    /**
     * 状态 0锁定 1有效
     */
    private String status;

    /**
     * 性别 0男 1女 2保密
     */
    private String ssex;

    private String startTime;

    private String endTime;

    private Integer pageSize;

    private Integer pageNum;
}
