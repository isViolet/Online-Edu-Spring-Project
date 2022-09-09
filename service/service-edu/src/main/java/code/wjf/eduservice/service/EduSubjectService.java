package code.wjf.eduservice.service;

import code.wjf.eduservice.entity.EduSubject;
import code.wjf.eduservice.entity.vo.SubjectNestedVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Natsume
 * @since 2022-09-09
 */
public interface EduSubjectService extends IService<EduSubject> {
    public void importSubjectData(MultipartFile file,EduSubjectService subjectService);

    List<SubjectNestedVo> getNestedTreeList();
}
