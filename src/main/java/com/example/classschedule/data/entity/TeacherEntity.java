package com.example.classschedule.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 老师实体类
 * @author fmh
 * @date 2024/9/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeacherEntity extends BaseEntity {

    /**
     * 姓名
     */
    private String teacherName;

    /**
     * 科目id
     */
    private String subjectId;
}
