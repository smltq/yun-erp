package com.easy.yunerp.sys.entity;

import com.easy.yunerp.common.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuntian
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ErpRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private String remark;


}
