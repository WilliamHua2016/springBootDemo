package org.william.springbootdemo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.william.springbootdemo.common.dao.model.Student;
import org.william.springbootdemo.common.exception.StudentNotFoundException;
import org.william.springbootdemo.common.rest.error.CommonErrors;
import org.william.springbootdemo.service.IStudentService;
import org.william.springbootdemo.web.vo.StudentVo;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentServiceImpl;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void addStudent(@RequestBody @Valid StudentVo studentVo) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo,student);
        studentServiceImpl.addStudent(student);
    }

    @RequestMapping(value = "/qryStudentByName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Student qryStudent(@RequestParam("name") String name) {
        Student student = studentServiceImpl.qryStudentByName(name);
        if (student == null) {
            throw new StudentNotFoundException(CommonErrors.STUDENT_NOT_FOUND, name);
        }
        return student;
    }

}
