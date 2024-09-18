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
}
