package com.o2o.entity;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by heanxing on 2018/10/13.
 */
public class Area {
    private Long id;
    private String areaName;//地区名字
    private int priorty;//权重
    private Data createTime;//创建时间
    private Date lastEditTime;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getPriorty() {
        return priorty;
    }

    public void setPriorty(int priorty) {
        this.priorty = priorty;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
