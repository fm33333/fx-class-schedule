package com.example.classschedule.controller;

import com.example.classschedule.data.entity.TeacherEntity;
import com.example.classschedule.data.result.R;
import com.example.classschedule.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    /**
     * 获取所有老师信息
     * @return
     */
    @GetMapping("/getAll")
    public R<List<TeacherEntity>> getAll() {
        return R.ok(teacherService.getAll());
    }


}
