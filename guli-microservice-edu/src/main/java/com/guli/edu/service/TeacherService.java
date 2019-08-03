package com.guli.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.common.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.common.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author luzhongjie
 * @since 2019-08-02
 */
public interface TeacherService extends IService<Teacher> {
    void pageQuery(Page page,TeacherQuery teacherQuery);

}
