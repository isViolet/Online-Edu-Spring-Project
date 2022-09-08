package code.wjf.eduservice.controller;


import code.wjf.commonutils.R;
import code.wjf.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@Api("讲师管理")
@EnableSwagger2 //解决 Unable to infer base url. This is common when using d...
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("list")
    @ApiOperation("列出所有讲师")
    public R list(){
        return R.ok().data("items", teacherService.list(null));
    }

    /*
    @ApiOperation：方法
    @ApiParam：参数
     */
    @DeleteMapping("removeById")
    @ApiOperation("根据id删除讲师")
    public R removeById(@ApiParam(name = "id", value = "讲师Id", required = true) @RequestParam String id){
        teacherService.removeById(id);
        return R.ok();
    }


}

