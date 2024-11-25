package com.example.classschedule.controller;

import com.example.classschedule.data.dto.ClassScheduleDTO;
import com.example.classschedule.data.entity.ClassEntity;
import com.example.classschedule.data.entity.ClassHourEntity;
import com.example.classschedule.data.entity.ClassScheduleEntity;
import com.example.classschedule.data.result.AjaxResult;
import com.example.classschedule.data.result.R;
import com.example.classschedule.data.vo.ClassScheduleVO;
import com.example.classschedule.service.ClassHourService;
import com.example.classschedule.service.ClassScheduleService;
import com.example.classschedule.service.ClassService;
import com.example.classschedule.util.poi.ExcelUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "课表管理")
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
    @Operation(summary  = "获取课表", method = "GET")
    @GetMapping("/getAll")
    public R<List<ClassScheduleEntity>> getAll() {
        return R.ok(classScheduleService.getAll());
    }


    /**
     * 获取可换课列表
     * @param classScheduleId 课表id
     * @return
     */
    @Operation(summary  = "根据id获取可换课列表", method = "POST")
    @PostMapping("/getChangeList")
    public R<List<ClassScheduleVO>> getChangeList(@RequestParam Integer classScheduleId) {
        return R.ok(classScheduleService.getChangeScheduleList(classScheduleId));
    }

    /**
     * 获取可换课列表
     * @param classScheduleDTO 课表信息
     * @return
     */
    @Operation(summary  = "根据课信息获取可换课列表", method = "POST")
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
        ExcelUtil<ClassScheduleVO> excelUtil = new ExcelUtil<ClassScheduleVO>(ClassScheduleVO.class);
        List<ClassScheduleVO> resultList = classScheduleService.getChangeScheduleList(classScheduleEntity.getId());
        // 导出结果
        excelUtil.exportExcel(resultList, "课表信息");
        return R.ok(resultList);
    }

    /**
     * 最初用于更新表中字段为中文值
     * @return
     */
//    @PostMapping("/update")
//    public R<Empty> update() {
//        return R.ok(classScheduleService.update());
//    }

    /**
     * 导出数据
     * @return
     */
    @Operation(summary  = "导出课表信息", method = "POST")
    @PostMapping("/export")
    public AjaxResult export() {
        List<ClassScheduleEntity> classScheduleEntityList = classScheduleService.getAll();
        ExcelUtil<ClassScheduleEntity> excelUtil = new ExcelUtil<ClassScheduleEntity>(ClassScheduleEntity.class);
        return AjaxResult.success(excelUtil.exportExcel(classScheduleEntityList, "课表信息"));
    }
}
