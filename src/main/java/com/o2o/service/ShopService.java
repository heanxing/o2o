package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;

import java.io.File;

/**
 * Created by heanxing on 2018/10/15.
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
