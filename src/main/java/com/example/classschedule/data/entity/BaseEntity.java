package com.example.classschedule.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 * @author fmh
 * @date 2024/9/10
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    protected static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
//    @TableId(type = IdType.AUTO)
    protected Integer id;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date modifyTime;

    /**
     * 是否删除(0: 未删除 1:已删除)
     */
    protected Boolean deleted;

}
