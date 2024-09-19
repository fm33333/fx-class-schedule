package com.example.classschedule.service;

import com.example.classschedule.entity.ClassScheduleEntity;
import com.example.classschedule.result.ResultCode;
import com.example.classschedule.vo.ClassScheduleVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassScheduleService {
    List<ClassScheduleEntity> getAll();

    List<ClassScheduleVO> getChangeScheduleList(Integer classScheduleId);

    ResultCode update();

    ClassScheduleEntity get(Integer singleDoubleWeek, Integer classId, Integer classHourId);
}
