package com.example.classschedule.service;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.ClassHourEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassHourService {
    List<ClassHourEntity> getAll();
}
