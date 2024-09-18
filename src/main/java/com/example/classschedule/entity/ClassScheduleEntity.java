package com.example.classschedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 课表实体类
 * @author fmh
 * @date 2024/9/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClassScheduleEntity extends BaseEntity {

    /**
     * 是否单双周课程（0：否，1：单周，2：双周）
     */
    private Integer singleDoubleWeek;

    /**
     * 班级id
     */
    private String classId;

    /**
     * 课时id
     */
    private String classHourId;

    /**
     * 老师id
     */
    private String teacherId;

    /**
     * 科目id
     */
    private String subjectId;
}
