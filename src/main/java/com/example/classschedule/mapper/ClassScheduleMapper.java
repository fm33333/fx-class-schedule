package com.example.classschedule.mapper;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.ClassScheduleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassScheduleMapper {

    /**
     * 获取所有课表信息
     * @return
     */
    List<ClassScheduleEntity> getAll();

    /**
     * 根据主键id获取课表信息
     * @param classScheduleId
     * @return
     */
    ClassScheduleEntity getById(@Param("classScheduleId") Integer classScheduleId);

    /**
     * 根据课时id获取该课时的所有课（如周一第3节的所有课程）
     * @param classHourId
     * @return
     */
    List<ClassScheduleEntity> getByClassHourId(@Param("classHourId") String classHourId);

    /**
     * 更新课表信息
     * @param classSchedule
     */
    void update(@Param("classSchedule") ClassScheduleEntity classSchedule);

    /**
     * 根据班级id获取课表信息
     * @param classId
     * @return
     */
    List<ClassScheduleEntity> getByClassId(@Param("classId") String classId);
}
