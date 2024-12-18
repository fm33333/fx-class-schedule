package com.example.classschedule.service;

import com.example.classschedule.data.entity.ClassHourEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassHourService {
    List<ClassHourEntity> getAll();

    ClassHourEntity get(String weekNum, String scheduleNum);
}
