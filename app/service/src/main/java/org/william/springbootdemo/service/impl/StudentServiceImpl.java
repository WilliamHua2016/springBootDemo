package org.william.springbootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.william.springbootdemo.common.dao.mapper.IStudentMapper;
import org.william.springbootdemo.common.dao.model.Student;
import org.william.springbootdemo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public Student qryStudentByName(String name) {
        return studentMapper.qryStudentByName(name);
    }

}
