package com.example.classschedule.mapper;

import com.example.classschedule.entity.ClassHourEntity;
import com.example.classschedule.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassHourMapper {

    /**
     * 获取所有课时信息
     * @return
     */
    List<ClassHourEntity> getAll();
}
