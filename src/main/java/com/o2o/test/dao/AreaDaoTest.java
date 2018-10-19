package com.o2o.test.dao;

import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import com.o2o.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * Created by heanxing on 2018/10/14.
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,areaList.size());

    }

}
