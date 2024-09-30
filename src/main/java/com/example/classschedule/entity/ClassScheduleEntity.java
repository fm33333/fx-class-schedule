package com.example.classschedule.entity;

import com.example.classschedule.annotation.Excel;
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
    @Excel(name = "是否单双周")
    private Integer singleDoubleWeek;

    /**
     * 班级id
     */
    @Excel(name = "班级")
    private String classId;

    /**
     * 课时id
     */
    @Excel(name = "课时")
    private String classHourId;

    /**
     * 老师id
     */
    @Excel(name = "老师")
    private String teacherId;

    /**
     * 科目id
     */
    @Excel(name = "科目")
    private String subjectId;
}
