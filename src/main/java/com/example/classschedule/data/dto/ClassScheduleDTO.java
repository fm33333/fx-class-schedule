package com.example.classschedule.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleDTO {

//    @Schema(description = "年级")
    private String gradeNum;

//    @Schema(description = "班级")
    private String classNum;

//    @Schema(description = "单双周（0：否，1：单，2：双）")
    private Integer singleDoubleWeek;

//    @Schema(description = "周")
    private String weekNum;

//    @Schema(description = "节")
    private String scheduleNum;


}
