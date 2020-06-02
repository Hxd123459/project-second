package com.aaa.hjd.vo;

import com.aaa.hjd.model.TUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UpdateUserVo implements Serializable {

    private Long id;
    private List roleIDs;
    private TUser user;

}
