package com.example.classschedule.service;

import com.example.classschedule.entity.ClassScheduleEntity;
import com.example.classschedule.result.ResultCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassScheduleService {
    List<ClassScheduleEntity> getAll();

    List<ClassScheduleEntity> getChangeScheduleList(Integer classScheduleId);

    ResultCode update();
}
