package org.william.springbootdemo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huawai on 2017/9/27.
 * Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String hello() {
        return "Hello Spring-Boot demo";
    }
}
