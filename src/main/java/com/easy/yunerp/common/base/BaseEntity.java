package com.easy.yunerp.common.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Entity基类
 */
@JsonIgnoreProperties(value = {"searchValue", "createBy", "createTime", "updateBy", "updateTime"})
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 搜索值
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private String searchValue;

    /**
     * 请求参数
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
