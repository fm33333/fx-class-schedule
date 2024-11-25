package com.example.classschedule.mapper;

import com.example.classschedule.data.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {

    /**
     * 获取所有老师信息
     * @return
     */
    List<TeacherEntity> getAll();

    /**
     * 根据id获取老师
     * @param id
     * @return
     */
    TeacherEntity getById(@Param("id") int id);
}
