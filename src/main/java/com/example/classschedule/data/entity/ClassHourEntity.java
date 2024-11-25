package com.example.classschedule.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 课时实体类
 * @author fmh
 * @date 2024/9/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClassHourEntity extends BaseEntity {

    /**
     * 周
     */
    private Integer week;

    /**
     * 第几节课
     */
    private Integer classNumber;

    /**
     * 课开始时间
     */
    private String classStartTime;

    /**
     * 课结束时间
     */
    private String classEndTime;
}
