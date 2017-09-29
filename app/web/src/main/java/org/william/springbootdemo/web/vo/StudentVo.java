package org.william.springbootdemo.web.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by huawai on 2017/9/29.
 * Description:
 */
public class StudentVo extends BaseVo{

    @NotBlank(message="{org.william.springbootdemo.valid.name.NotBlank.message}")
    private String name;
    @NotBlank(message="{org.william.springbootdemo.valid.sex.NotBlank.message}")
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
