package com.example.classschedule.mapper;

import com.example.classschedule.entity.ClassHourEntity;
import com.example.classschedule.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassHourMapper {

    /**
     * 获取所有课时信息
     * @return
     */
    List<ClassHourEntity> getAll();

    /**
     * 根据周和节数查询实体
     * @param weekNum
     * @param scheduleNum
     * @return
     */
    ClassHourEntity getByWeekSchedule(@Param("weekNum") String weekNum, @Param("scheduleNum") String scheduleNum);
}
