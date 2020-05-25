package com.aaa.hjd.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/11 0011
 * Time: 22:54
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")//新增返回主键
    private Long id;

    @Column(name = "create_time")
    @Max(value = 100,message = "时间最长不能超过100")
    private String createTime;

    @Column(name="modify_time")
    @Max(value = 100,message = "时间最长不能超过100")
    private String modifyTime;

}
