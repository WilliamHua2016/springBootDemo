package org.william.springbootdemo.web.vo;

import java.util.Date;

/**
 * Created by huawai on 2017/9/29.
 * Description:
 */
public abstract class BaseVo {

    private long id;

    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
