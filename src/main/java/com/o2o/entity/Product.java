package com.o2o.entity;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by heanxing on 2018/10/13.
 */
public class Product {
    private Long id;
    private String productName;
    private String productDesc;
    //减缩图
    private String imgAddr;
    private String normalPrice;//原价
    private String promotionPrice;//折扣价
    private int priority;
    private Date createTime;
    private Date lastEditTime;
    //0.下架  1.在前端展示
    private int enableStatus;
    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;

}
