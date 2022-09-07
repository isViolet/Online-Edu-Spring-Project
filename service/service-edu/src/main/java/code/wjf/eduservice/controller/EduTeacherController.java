package code.wjf.eduservice.controller;


import code.wjf.eduservice.entity.EduTeacher;
import code.wjf.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Natsume
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("list")
    public List<EduTeacher> list(){
        return teacherService.list(null);
    }

    @DeleteMapping("removeById")
    public boolean removeById(@RequestParam String id){
        return teacherService.removeById(id);
    }


}

