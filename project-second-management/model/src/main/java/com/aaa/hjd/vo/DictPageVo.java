package com.aaa.hjd.vo;

import com.aaa.hjd.model.Dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/23 0023
 * Time: 14:18
 * Description:
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    /**
     * 字段数据
     */
    private Dict dict;
    /**
     * 一页显示多少
     */
   private Integer pageSize;
    /**
     * 第几页
     */
   private Integer pageNum;
    /**
     * 数据总数
     */
   private Integer total;

}
