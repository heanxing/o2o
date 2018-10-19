package com.o2o.test.service;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import com.o2o.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
;
import java.util.List;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * Created by heanxing on 2018/10/14.
 */
public class AreaServiceTest extends BaseTest {
    @Autowired

    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西安",areaList.get(0).getAreaName());


    }
}
