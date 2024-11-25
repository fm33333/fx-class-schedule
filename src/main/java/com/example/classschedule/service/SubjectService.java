package com.example.classschedule.service;

import com.example.classschedule.data.entity.SubjectEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<SubjectEntity> getAll();

    SubjectEntity getById(Integer id);
}
