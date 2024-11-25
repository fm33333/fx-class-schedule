package com.example.classschedule.service.impl;

import com.example.classschedule.data.entity.SubjectEntity;
import com.example.classschedule.mapper.SubjectMapper;
import com.example.classschedule.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    /**
     * 获取所有科目信息
     * @return
     */
    @Override
    public List<SubjectEntity> getAll() {
        log.info("SubjectService | getAll");
        return subjectMapper.getAll();
    }

    @Override
    public SubjectEntity getById(Integer id) {
        log.info("SubjectService | getById: {}", id);
        return subjectMapper.getById(id);
    }
}
