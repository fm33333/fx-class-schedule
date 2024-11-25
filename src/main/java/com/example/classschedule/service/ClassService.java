package com.example.classschedule.service;

import com.example.classschedule.data.entity.ClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    List<ClassEntity> getAll();

    ClassEntity getById(String id);

    ClassEntity get(String gradeNum, String classNum);
}
