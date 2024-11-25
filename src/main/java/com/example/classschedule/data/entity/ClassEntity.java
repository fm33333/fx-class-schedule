package com.example.classschedule.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 班级实体类
 * @author fmh
 * @date 2024/9/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClassEntity extends BaseEntity {

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 班级
     */
    private Integer classNum;
}
