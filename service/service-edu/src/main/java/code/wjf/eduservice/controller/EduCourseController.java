package code.wjf.eduservice.controller;


import code.wjf.commonutils.R;
import code.wjf.eduservice.entity.vo.CourseInfoForm;
import code.wjf.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Natsume
 * @since 2022-09-14
 */
@Api(description="课程管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu-service/edu-course")
public class EduCourseController {
    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "新增课程")
    @PostMapping("saveCourseInfo")
    public R saveCourseInfo(
            @ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm){

        String courseId = courseService.saveCourseInfo(courseInfoForm);
        if(!StringUtils.isEmpty(courseId)){
            return R.ok().data("courseId", courseId);
        }else{
            return R.error().message("保存失败");
        }
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("getById")
    public R getById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @RequestParam String id){

        CourseInfoForm courseInfoForm = courseService.getCourseInfoFormById(id);
        return R.ok().data("item", courseInfoForm);
    }

    @ApiOperation(value = "更新课程")
    @PutMapping("updateCourseInfoById")
    public R updateCourseInfoById(
            @ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm,

            @ApiParam(name = "id", value = "课程ID", required = true)
            @RequestParam String id){

        courseService.updateCourseInfoById(courseInfoForm);
        return R.ok();
    }
}

