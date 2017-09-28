package org.william.springbootdemo.service;


import org.william.springbootdemo.common.dao.model.Student;

public interface IStudentService {
	
	public void addStudent(Student student);

	Student qryStudentByName(String name);
}
