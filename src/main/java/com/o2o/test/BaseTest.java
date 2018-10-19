package com.o2o.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by heanxing on 2018/10/14.
 */
/*
*
* 配置spring和junit整合，junit启动时加载springIOC容器
*
* */
//告诉unit spring配置文件的位置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
