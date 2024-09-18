package com.example.classschedule.controller;

import com.example.classschedule.entity.ClassScheduleEntity;
import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.result.Empty;
import com.example.classschedule.result.R;
import com.example.classschedule.service.ClassScheduleService;
import com.example.classschedule.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class-schedule")
public class ClassScheduleController {

    @Autowired
    ClassScheduleService classScheduleService;

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
     * @return
     */
    @PostMapping("/getChangeList")
    public R<List<ClassScheduleEntity>> getChangeList(@RequestParam Integer classScheduleId) {
        return R.ok(classScheduleService.getChangeScheduleList(classScheduleId));
    }
    

    @PostMapping("/update")
    public R<Empty> update() {
        return R.ok(classScheduleService.update());
    }
}
