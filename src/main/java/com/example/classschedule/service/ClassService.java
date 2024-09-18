package com.example.classschedule.service;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    List<ClassEntity> getAll();

    ClassEntity getById(String id);
}
