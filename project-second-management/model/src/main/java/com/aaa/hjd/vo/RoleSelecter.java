package com.aaa.hjd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * User: Aurora
 * Date: 2020/5/22
 * Time: 1:30
 * 角色的查询vo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class RoleSelecter implements Serializable {
    //角色名
    private String roleName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
}
