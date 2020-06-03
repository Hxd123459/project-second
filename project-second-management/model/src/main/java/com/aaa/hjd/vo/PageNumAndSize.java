package com.aaa.hjd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageNumAndSize {

    /**
     * 每页几条
     */
    private Integer pageSize;
    /**
     * 第几页
     */
    private Integer pageNum;
}
