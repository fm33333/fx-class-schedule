package com.example.classschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleDTO {

    // 年级
    private String gradeNum;
    // 班级
    private String classNum;
    // 单双周（0：否，1：单，2：双）
    private Integer singleDoubleWeek;
    // 周
    private String weekNum;
    // 节
        private String scheduleNum;


}
