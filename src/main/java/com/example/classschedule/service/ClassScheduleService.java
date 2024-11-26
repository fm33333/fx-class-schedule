package com.example.classschedule.service;

import com.example.classschedule.data.entity.ClassScheduleEntity;
import com.example.classschedule.data.result.R;
import com.example.classschedule.data.result.ResultCode;
import com.example.classschedule.data.vo.ClassScheduleVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ClassScheduleService {
    List<ClassScheduleEntity> getAll();

    List<ClassScheduleVO> getChangeScheduleList(Integer classScheduleId);

    ResultCode update();

    ClassScheduleEntity get(Integer singleDoubleWeek, Integer classId, Integer classHourId);

    R importData(MultipartFile file);
}
