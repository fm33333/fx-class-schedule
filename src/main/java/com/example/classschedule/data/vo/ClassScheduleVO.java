package com.example.classschedule.data.vo;

import com.example.classschedule.annotation.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Excel(name = "单双周课程", readConverterExp = "0=否,1=单周,2=双周")
    @Schema(description = "单双周课程")
    private Integer singleDoubleWeek;

    /**
     * 班级id
     */
    @Excel(name = "班级")
    @Schema(description = "班级")
    private String classId;

    /**
     * 课时id
     */
    @Excel(name = "课时")
    @Schema(description = "课时")
    private String classHourId;

    /**
     * 老师id
     */
    @Excel(name = "老师")
    @Schema(description = "老师")
    private String teacherId;

    /**
     * 科目id
     */
    @Excel(name = "科目")
    @Schema(description = "科目")
    private String subjectId;

}
