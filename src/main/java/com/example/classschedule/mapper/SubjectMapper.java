package com.example.classschedule.mapper;

import com.example.classschedule.data.entity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {

    /**
     * 获取所有科目
     * @return
     */
    List<SubjectEntity> getAll();

    /**
     * 根据主键id获取科目
     * @param id
     * @return
     */
    SubjectEntity getById(@Param("id") Integer id);
}
