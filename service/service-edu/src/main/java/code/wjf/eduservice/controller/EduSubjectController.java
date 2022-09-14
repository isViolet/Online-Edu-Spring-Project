package code.wjf.eduservice.controller;


import code.wjf.commonutils.R;
import code.wjf.eduservice.entity.EduSubject;
import code.wjf.eduservice.entity.vo.SubjectNestedVo;
import code.wjf.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Natsume
 * @since 2022-09-09
 */
@Api(description="课程分类管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu-service/edu-subject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    @ApiOperation("获取所有一级课程分类")
    @GetMapping("listAllOneSubject")
    public R listAllOneSubject(){
        return R.ok().data("items", subjectService.list(new QueryWrapper<EduSubject>().eq("parent_id", 0)));
    }

    //添加课程分类
    @ApiOperation(value = "Excel批量导入")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        subjectService.importSubjectData(file,subjectService);
        //判断返回集合是否为空
        return R.ok();
    }

    @ApiOperation(value = "嵌套数据列表")
    @GetMapping("getNestedTreeList")
    public R getNestedTreeList(){

        List<SubjectNestedVo> subjectNestedVoList = subjectService.getNestedTreeList();
        return R.ok().data("items", subjectNestedVoList);
    }
}
