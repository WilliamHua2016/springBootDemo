package org.william.springbootdemo.common.dao.mapper;

import org.william.springbootdemo.common.dao.model.Student;

public interface IStudentMapper {

    void addStudent(Student student);

    Student qryStudentByName(String name);
}
