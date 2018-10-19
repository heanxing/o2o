package com.o2o.test.dao;

import com.o2o.dao.ShopDao;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by heanxing on 2018/10/14.
 */
public class ShopDaoTest  extends BaseTest{
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testInsertShop(){
        Shop shop=new Shop();
        shop.setId(1L);
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setId(1L);
        area.setId(2L);
        shopCategory.setId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺11");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("123456789");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNUm=shopDao.insertShop(shop);
        assertEquals(1,effectedNUm);
    }
    @Test
    public void testupdateShop(){
        Shop shop=new Shop();
        shop.setId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        int effectedNUm=shopDao.updateShop(shop);
        assertEquals(1,effectedNUm);




    }
}
