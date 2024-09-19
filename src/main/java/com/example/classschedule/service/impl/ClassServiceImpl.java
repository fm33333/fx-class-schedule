package com.example.classschedule.service.impl;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.mapper.ClassMapper;
import com.example.classschedule.mapper.TeacherMapper;
import com.example.classschedule.service.ClassService;
import com.example.classschedule.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    /**
     * 获取所有老师信息
     * @return
     */
    @Override
    public List<ClassEntity> getAll() {
        log.info("ClassService|getAll");
        return classMapper.getAll();
    }

    /**
     * 根据主键id获取班级信息
     * @param id
     * @return
     */
    @Override
    public ClassEntity getById(String id) {
        return classMapper.getById(id);
    }

    @Override
    public ClassEntity get(String gradeNum, String classNum) {
        return classMapper.getByGradeClass(gradeNum, classNum);
    }
}
