package code.wjf.eduservice.controller;


import code.wjf.commonutils.R;
import code.wjf.eduservice.entity.EduTeacher;
import code.wjf.eduservice.entity.vo.TeacherQuery;
import code.wjf.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageList")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @RequestParam Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @RequestParam Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            TeacherQuery teacherQuery){

        //创建page类
        Page<EduTeacher> pageParam = new Page<>(page, limit);

        //teacherService.page(pageParam, null);

        //服务类调用page函数，传入page和查询条件，获取数据
        teacherService.pageQuery(pageParam, teacherQuery);

        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

}

