package com.example.classschedule.controller;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.result.R;
import com.example.classschedule.service.ClassService;
import com.example.classschedule.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    /**
     * 获取所有班级信息
     * @return
     */
    @GetMapping("/getAll")
    public R<List<ClassEntity>> getAll() {
        return R.ok(classService.getAll());
    }


}
