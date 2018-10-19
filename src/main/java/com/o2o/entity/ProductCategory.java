package com.o2o.entity;

import java.util.Date;

/**
 * Created by heanxing on 2018/10/13.
 */
public class ProductCategory {
    private Long id;
    private Long shopId;//属于哪个店
    private String productCategorynName;
    private int priority;
    private Date careateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategorynName() {
        return productCategorynName;
    }

    public void setProductCategorynName(String productCategorynName) {
        this.productCategorynName = productCategorynName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCareateTime() {
        return careateTime;
    }

    public void setCareateTime(Date careateTime) {
        this.careateTime = careateTime;
    }
}
