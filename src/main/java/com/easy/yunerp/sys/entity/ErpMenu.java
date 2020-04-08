package com.easy.yunerp.sys.entity;

import java.time.LocalDateTime;

import com.easy.yunerp.common.base.BaseEntity;
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
public class ErpMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级菜单ID
     */
    private Integer parent;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单排序
     */
    private Integer order;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 菜单icon
     */
    private String icon;

    private String type;


}
