package com.aaa.hjd.vo;

import com.aaa.hjd.model.TMappingProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/26 0026
 * Time: 10:10
 * Description:
 * 项目的vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TMappingProjectPageVo {
    private TMappingProject mappingProject;
    private Integer pageNum;
    private Integer pageSize;
}
