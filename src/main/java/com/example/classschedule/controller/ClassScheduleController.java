package com.example.classschedule.controller;

import com.example.classschedule.dto.ClassScheduleDTO;
import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.ClassHourEntity;
import com.example.classschedule.entity.ClassScheduleEntity;
import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.result.Empty;
import com.example.classschedule.result.R;
import com.example.classschedule.service.ClassHourService;
import com.example.classschedule.service.ClassScheduleService;
import com.example.classschedule.service.ClassService;
import com.example.classschedule.service.TeacherService;
import com.example.classschedule.vo.ClassScheduleVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/class-schedule")
public class ClassScheduleController {

    @Autowired
    ClassScheduleService classScheduleService;
    @Autowired
    ClassService classService;
    @Autowired
    ClassHourService classHourService;

    /**
     * 获取所有课表信息
     * @return
     */
    @GetMapping("/getAll")
    public R<List<ClassScheduleEntity>> getAll() {
        return R.ok(classScheduleService.getAll());
    }


    /**
     * 获取可换课列表
     * @param classScheduleId 课表id
     * @return
     */
    @PostMapping("/getChangeList")
    public R<List<ClassScheduleVO>> getChangeList(@RequestParam Integer classScheduleId) {
        return R.ok(classScheduleService.getChangeScheduleList(classScheduleId));
    }

    /**
     * 获取可换课列表
     * @param classScheduleDTO 课表信息
     * @return
     */
    @PostMapping("/getChangeList2")
    public R<List<ClassScheduleVO>> getChangeList2(@RequestBody ClassScheduleDTO classScheduleDTO) {
        // 分别查询出对应的classId和classHourId，再根据classId和classHourId查询到对应的classScheduleId
        ClassEntity classEntity = classService.get(
                classScheduleDTO.getGradeNum(), classScheduleDTO.getClassNum());
        ClassHourEntity classHourEntity = classHourService.get(
                classScheduleDTO.getWeekNum(), classScheduleDTO.getScheduleNum());
        ClassScheduleEntity classScheduleEntity = classScheduleService.get(
                classScheduleDTO.getSingleDoubleWeek(), classEntity.getId(), classHourEntity.getId());
//        log.info("getChangeList2 | classEntity: {}", classEntity);
//        log.info("getChangeList2 | classHourEntity: {}", classHourEntity);
//        log.info("getChangeList2 | classScheduleEntity: {}", classScheduleEntity);
        return R.ok(classScheduleService.getChangeScheduleList(classScheduleEntity.getId()));
    }

    /**
     * 最初用于更新表中字段为中文值
     * @return
     */
//    @PostMapping("/update")
//    public R<Empty> update() {
//        return R.ok(classScheduleService.update());
//    }
}
