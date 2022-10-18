package code.wjf.eduservice.controller;


import code.wjf.commonutils.R;
import code.wjf.eduservice.entity.EduChapter;
import code.wjf.eduservice.entity.vo.ChapterVo;
import code.wjf.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Natsume
 * @since 2022-10-18
 */
@Api(description="课程章节管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu-service/edu-chapter")
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    @ApiOperation(value = "嵌套章节数据列表")
    @GetMapping("nestedListByCourseId")
    public R nestedListByCourseId(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @RequestParam String courseId){

        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);
        return R.ok().data("items", chapterVoList);
    }

    @ApiOperation("查询所有")
    @GetMapping("listChapter")
    public R listChapter(){
        List<EduChapter> chapterList = chapterService.list(null);
        return R.ok().data("items", chapterList);
    }
}

