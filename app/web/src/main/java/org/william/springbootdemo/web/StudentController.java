package org.william.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.william.springbootdemo.common.dao.model.Student;
import org.william.springbootdemo.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentServiceImpl;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void addStudent(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        studentServiceImpl.addStudent(student);
    }

	@RequestMapping(value = "/qryStudentByName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Student qryStudent(@RequestParam("name") String name){
		Student student = studentServiceImpl.qryStudentByName(name);
		return student;
	}

}
