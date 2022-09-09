package code.wjf.eduservice.service;

import code.wjf.eduservice.entity.EduTeacher;
import code.wjf.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Natsume
 * @since 2022-09-07
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

    public boolean removeById(Serializable id);
}

