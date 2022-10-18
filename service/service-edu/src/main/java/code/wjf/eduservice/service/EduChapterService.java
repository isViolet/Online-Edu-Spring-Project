package code.wjf.eduservice.service;

import code.wjf.eduservice.entity.EduChapter;
import code.wjf.eduservice.entity.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Natsume
 * @since 2022-10-18
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> nestedList(String courseId);
}
