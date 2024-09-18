package com.example.classschedule;

import com.example.classschedule.entity.ClassEntity;
import com.example.classschedule.entity.ClassScheduleEntity;
import com.example.classschedule.entity.SubjectEntity;
import com.example.classschedule.entity.TeacherEntity;
import com.example.classschedule.mapper.ClassMapper;
import com.example.classschedule.mapper.ClassScheduleMapper;
import com.example.classschedule.mapper.SubjectMapper;
import com.example.classschedule.mapper.TeacherMapper;
import com.example.classschedule.service.ClassScheduleService;
import com.example.classschedule.service.impl.ClassScheduleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class ClassScheduleApplicationTests {

    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassMapper classMapper;

    @Autowired
    ClassScheduleServiceImpl classScheduleService;
    @Autowired
    ClassScheduleMapper classScheduleMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        List<ClassScheduleEntity> classScheduleEntities = classScheduleMapper.getAll();
        List<ClassScheduleEntity> entities = new ArrayList<>();
        // 遍历List
        Iterator<ClassScheduleEntity> iterator = classScheduleEntities.iterator();
        while (iterator.hasNext()) {
            ClassScheduleEntity entity = iterator.next();
            if (Integer.parseInt(entity.getClassHourId()) <= 7) {
                entities.add(entity);
            }
        }
//        System.out.println(classScheduleEntities.toString());
        System.out.println(entities.size());
        System.out.println(entities);
    }


    @Test
    void test2() {
        String teacher = "郭霄涵";
        List<ClassScheduleEntity> csList = new ArrayList<>();
        ClassScheduleEntity entity1 = new ClassScheduleEntity(0, "1", "1", "a", "心理健康");
        ClassScheduleEntity entity2 = new ClassScheduleEntity(0, "1", "1", "b", "心理健康");
        ClassScheduleEntity entity3 = new ClassScheduleEntity(0, "1", "1", "郭霄涵", "心理健康");
        csList.add(entity1);
        csList.add(entity2);
        csList.add(entity3);
        boolean isExist = classScheduleService.isExistClassSchedule(teacher, csList);
        System.out.println(isExist);
    }

}
