package com.example.classschedule.mapper;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {

    /**
     * 获取所有班级信息
     * @return
     */
    List<ClassEntity> getAll();

    ClassEntity getById(@Param("id") String id);

    /**
     * 根据年级、班级获取实体
     * @param gradeNum
     * @param classNum
     * @return
     */
    ClassEntity getByGradeClass(@Param("gradeNum") String gradeNum, @Param("classNum") String classNum);
}
