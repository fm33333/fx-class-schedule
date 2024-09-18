package com.example.classschedule.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleVO {

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
