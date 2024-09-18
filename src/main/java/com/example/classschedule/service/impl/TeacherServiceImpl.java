package com.example.classschedule.service.impl;

import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.mapper.TeacherMapper;
import com.example.classschedule.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    /**
     * 获取所有老师信息
     * @return
     */
    @Override
    public List<TeacherEntity> getAll() {
        log.info("TeacherService | getAll");
        return teacherMapper.getAll();
    }

    /**
     * 根据主键id获取老师
     * @param id
     * @return
     */
    @Override
    public TeacherEntity getById(int id) {
        log.info("TeacherService | getById: {}", id);
        return teacherMapper.getById(id);
    }
}
