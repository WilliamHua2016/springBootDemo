package org.william.springbootdemo.web.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.william.springbootdemo.common.dao.model.Student;

/**
 * Created by huawai on 2017/9/27.
 * Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping
    public String hello() {

        Student student = new Student();
        student.setName("huawei");
        student.setSex("test");
        amqpTemplate.convertAndSend("fincloud.exchange.notification", "fincloud.routingKey.sms",student);
        return "Hello Spring-Boot demo";
    }
}
