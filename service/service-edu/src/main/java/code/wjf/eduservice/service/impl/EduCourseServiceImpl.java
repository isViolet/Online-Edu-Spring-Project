package code.wjf.eduservice.service.impl;

import code.wjf.commonutils.ResultCodeEnum;
import code.wjf.eduservice.entity.EduCourse;
import code.wjf.eduservice.entity.EduCourseDescription;
import code.wjf.eduservice.entity.vo.CourseInfoForm;
import code.wjf.eduservice.mapper.EduCourseMapper;
import code.wjf.eduservice.service.EduCourseDescriptionService;
import code.wjf.eduservice.service.EduCourseService;
import code.wjf.servicebase.exception.CustomizeException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Natsume
 * @since 2022-09-14
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduCourseDescriptionService courseDescriptionService;

    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {

        //保存课程基本信息
        EduCourse course = new EduCourse();
        course.setStatus(EduCourse.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoForm, course);
        boolean resultCourseInfo = this.save(course);
        if(!resultCourseInfo){
            throw new CustomizeException(ResultCodeEnum.ADD_COURSE_INFO_ERROR);
        }

        //保存课程详情信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.save(courseDescription);
        if(!resultDescription){
            throw new CustomizeException(ResultCodeEnum.ADD_COURSE_DETAIL_INFO_ERROR);
        }

        return course.getId();
    }

    @Override
    public CourseInfoForm getCourseInfoFormById(String id) {

        EduCourse course = this.getById(id);
        if(course == null){
            throw new CustomizeException(ResultCodeEnum.NoData);
        }
        CourseInfoForm courseInfoForm = new CourseInfoForm();
        BeanUtils.copyProperties(course, courseInfoForm);

        EduCourseDescription courseDescription = courseDescriptionService.getById(id);
        if(course != null){
            courseInfoForm.setDescription(courseDescription.getDescription());
        }

        return courseInfoForm;
    }

    @Override
    public void updateCourseInfoById(CourseInfoForm courseInfoForm) {
        //保存课程基本信息
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm, course);
        boolean resultCourseInfo = this.updateById(course);
        if(!resultCourseInfo){
            throw new CustomizeException(ResultCodeEnum.UPDATE_COURSE_INFO_ERROR);
        }

        //保存课程详情信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.updateById(courseDescription);
        if(!resultDescription){
            throw new CustomizeException(ResultCodeEnum.UPDATE_COURSE_DETAIL_INFO_ERROR);
        }
    }
}
