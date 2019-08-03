package com.guli.edu.controller.admin;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.common.constant.ResultCodeEnum;
import com.guli.edu.common.entity.Teacher;
import com.guli.edu.common.entity.vo.ResultEntity;
import com.guli.edu.common.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "讲师管理")
@RestController
@RequestMapping("admin/edu/teacher")
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询teacher信息
     * @return
     */
    @ApiOperation(value = "所有的讲师列表")
    @GetMapping
    public ResultEntity list(){
        List<Teacher> list = teacherService.list(null);
        return ResultEntity.ok().data("teachers",list);
    }



    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @ApiOperation("根据id删除讲师")
    @DeleteMapping("{id}")
    public ResultEntity remove(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable("id") String id){
        boolean b = teacherService.removeById(id);
        if (b == true){
            return ResultEntity.ok();
        }else {
            return ResultEntity.error();
        }

    }


    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public ResultEntity pageList(
            @ApiParam(name = "page",value = "当前页面",required = true)
            @PathVariable("page") Integer page,
            @ApiParam(name = "limit",value = "每页显示行数",required = true)
            @PathVariable("limit") Integer limit,
            TeacherQuery teacherQuery
                                 ){
        Page<Teacher> teacherPage = new Page<>(page,limit);
        teacherService.pageQuery(teacherPage,teacherQuery);
        return ResultEntity.ok().data("total",teacherPage.getTotal()).data("records",teacherPage.getRecords());
    }


    @ApiOperation(value = "根据teacher添加讲师")
    @PostMapping("add")
    public ResultEntity add(
            @ApiParam(name = "teacher",value = "讲师对象",required = true)
            @RequestBody Teacher teacher
    ){
        boolean save = teacherService.save(teacher);
        if(save==true){
            return ResultEntity.ok();
        }else{
            return ResultEntity.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public ResultEntity getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        Teacher teacher = teacherService.getById(id);
        return ResultEntity.ok().data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public ResultEntity updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        teacher.setId(id);
        teacherService.updateById(teacher);
        return ResultEntity.ok();
    }







}
