package com.example.classschedule.service;

import com.example.classschedule.entity.SubjectEntity;
import com.example.classschedule.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<SubjectEntity> getAll();

    SubjectEntity getById(Integer id);
}
