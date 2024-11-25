package com.example.classschedule.service;

import com.example.classschedule.data.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<TeacherEntity> getAll();

    TeacherEntity getById(int id);

}
