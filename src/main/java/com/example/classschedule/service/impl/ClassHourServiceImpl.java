package com.example.classschedule.service.impl;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.ClassHourEntity;
import com.example.classschedule.mapper.ClassHourMapper;
import com.example.classschedule.service.ClassHourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("classHourService")
public class ClassHourServiceImpl implements ClassHourService {

    @Autowired
    ClassHourMapper classHourMapper;

    /**
     * 获取所有老师信息
     * @return
     */
    @Override
    public List<ClassHourEntity> getAll() {
        log.info("ClassService|getAll");
        return classHourMapper.getAll();
    }
}
