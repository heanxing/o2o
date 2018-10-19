package com.o2o.test.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import com.o2o.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * Created by heanxing on 2018/10/15.
 */

public class ShopServicrTest extends BaseTest  {
    @Autowired
    private ShopService shopService;
    @Test
    public void  testAddShop(){
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setId(1L);
        area.setId(2L);
        shopCategory.setId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺1");
        shop.setShopDesc("test11");
        shop.setShopAddr("test11");
        shop.setPhone("12345678911");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中1");
        File shopImg = new File("/Users/images/long.jpg");
        ShopExecution se=shopService.addShop(shop,shopImg);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());

    }

}
