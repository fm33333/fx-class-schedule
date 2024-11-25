package com.example.classschedule.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 科目实体类
 * @author fmh
 * @date 2024/9/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubjectEntity extends BaseEntity {

    /**
     * 科目
     */
    private String subject;

}
