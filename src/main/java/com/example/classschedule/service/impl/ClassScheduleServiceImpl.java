package com.example.classschedule.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.example.classschedule.entity.*;
import com.example.classschedule.mapper.ClassScheduleMapper;
import com.example.classschedule.result.ResultCode;
import com.example.classschedule.result.ResultCodeEnum;
import com.example.classschedule.service.*;
import com.example.classschedule.util.StringUtil;
import com.example.classschedule.vo.ClassScheduleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service("classScheduleService")
public class ClassScheduleServiceImpl implements ClassScheduleService {

    @Autowired
    ClassScheduleMapper classScheduleMapper;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ClassService classService;
    @Autowired
    ClassHourService classHourService;

    /**
     * 获取所有老师信息
     * @return
     */
    @Override
    public List<ClassScheduleEntity> getAll() {
        log.info("ClassScheduleService|getAll");
        return classScheduleMapper.getAll();
    }

    /**
     * 获取可换课列表
     *   要求：1、找出可以和哪节课换，本人可以上哪节
     *        2、进阶逻辑：同一个班不能连上几节课/同一个班不能两天没有同一节课（具体需要再确认）
     * TODO：当前逻辑还不够完善，没有对单双周的逻辑处理；并且没有判断是否有连上多节课或者两天没有某节课的情况
     * @param classScheduleId 待换课的课表id
     * @return
     */
    @Override
    public List<ClassScheduleVO> getChangeScheduleList(Integer classScheduleId) {
        log.info("getChangeScheduleList|classScheduleId: {}", classScheduleId);
        // 查出待换的课信息
        ClassScheduleEntity waitToChange = classScheduleMapper.getById(classScheduleId);
        Integer singleDoubleWeek = waitToChange.getSingleDoubleWeek();  // 单双周（0否，1单周，2双周）
        String classId = waitToChange.getClassId();     // 班级
        String classHourId = waitToChange.getClassHourId(); // 课时（周几第几节）
        String teacherId = waitToChange.getTeacherId(); // 老师
        String subjectId = waitToChange.getSubjectId(); // 科目
        log.info("getChangeScheduleList | waitToChange: {}", waitToChange);

        // 查出该节课时的所有课表信息（后面用于判断被换课的老师在这一节课时中是否有课，有课则换不了）
        List<ClassScheduleEntity> currentClassHourList = classScheduleMapper.getByClassHourId(classHourId);

        // 查出该班级的所有课表信息（换课肯定是本班内换吧）
        List<ClassScheduleEntity> allClassScheduleList = classScheduleMapper.getByClassId(classId);
        // 遍历该班级课表，查找可换的课
        List<ClassScheduleVO> resultList = new ArrayList<>();   // 可换的课列表
        Iterator<ClassScheduleEntity> iterator = allClassScheduleList.iterator();
        while (iterator.hasNext()) {
            ClassScheduleEntity next = iterator.next();
            // 第7节课没课，跳过
            if(next.getTeacherId() == null || next.getSubjectId() == null) {
                continue;
            }
            // 同一老师的课，跳过
            if(waitToChange.getSubjectId().equals(next.getSubjectId())) {
                continue;
            }
            // 获取被换课的课时的所有课表信息，待换课老师在该课时不能有课
            List<ClassScheduleEntity> nextClassHourList = classScheduleMapper.getByClassHourId(next.getClassHourId());
            if(isExistClassSchedule(teacherId, nextClassHourList)) {
                continue;
            }
            // 待换课的课时的所有课中，被换课老师也不能有课
            if(isExistClassSchedule(next.getTeacherId(), currentClassHourList)) {
                continue;
            }

            // 处理返回字段值
            ClassEntity classEntity = classService.getById(next.getClassId());
            next.setClassId(classEntity.getGrade() + "年" + classEntity.getClassNum() + "班");
            log.info("getChangeScheduleList | classHourId: {}", next.getClassHourId());
            next.setClassHourId(
                    "周" + (Integer.parseInt(next.getClassHourId()) / 7 + 1) +
                    "第" + (Integer.parseInt(next.getClassHourId()) % 7) + "节"
            );
            log.info("getChangeScheduleList | classHourId: {}", next.getClassHourId());
            ClassScheduleVO resultVO = new ClassScheduleVO(next.getSingleDoubleWeek(), next.getClassId(),
                    next.getClassHourId(), next.getTeacherId(), next.getSubjectId());
            resultList.add(resultVO);
        }

        return resultList;
    }

    /**
     * 判断老师teacher是否存在于课表csList中（即判断老师在该节课是否有其他班的课要上）
     * @param teacher
     * @param csList
     * @return
     */
    public boolean isExistClassSchedule(String teacher, List<ClassScheduleEntity> csList) {
        Iterator<ClassScheduleEntity> iterator = csList.iterator();
        while (iterator.hasNext()) {
            ClassScheduleEntity next = iterator.next();
            if (teacher.equals(next.getTeacherId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 更新一下表里面【老师】和【课程】字段值为中文，方便查看和统一处理
     *
     * @return
     */
    @Override
    public ResultCode update() {
        List<ClassScheduleEntity> allSchedule = classScheduleMapper.getAll();
        Iterator<ClassScheduleEntity> iterator = allSchedule.iterator();
        while(iterator.hasNext()) {
            ClassScheduleEntity next = iterator.next();
            log.info("Updated | next: {}", next);
            // 【科目】字段
            if(StringUtil.isNumeric(next.getSubjectId())) {
                SubjectEntity subject = subjectService.getById(Integer.parseInt(next.getSubjectId()));
                log.info("Updated | subject: {}", subject);
                next.setSubjectId(subject.getSubject());
                log.info("Updated | next: {}", next);
            }
            // 【老师】字段
            if(StringUtil.isNumeric(next.getTeacherId())) {
                TeacherEntity teacher = teacherService.getById(Integer.parseInt(next.getTeacherId()));
                log.info("Updated | teacher: {}", teacher);
                next.setTeacherId(teacher.getTeacherName());
                log.info("Updated | next: {}", next);
            }
            classScheduleMapper.update(next);
        }
        return ResultCodeEnum.SUCCESS;
    }

    @Override
    public ClassScheduleEntity get(Integer singleDoubleWeek, Integer classId, Integer classHourId) {
        return classScheduleMapper.get(singleDoubleWeek, classId, classHourId);
    }


}
