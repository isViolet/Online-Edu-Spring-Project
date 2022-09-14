package code.wjf.eduservice.service;

import code.wjf.eduservice.entity.EduCourse;
import code.wjf.eduservice.entity.vo.CourseInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Natsume
 * @since 2022-09-14
 */
public interface EduCourseService extends IService<EduCourse> {
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);
    void updateCourseInfoById(CourseInfoForm courseInfoForm);
}
