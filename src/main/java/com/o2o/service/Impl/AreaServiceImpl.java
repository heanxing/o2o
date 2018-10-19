package com.o2o.service.Impl;

import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heanxing on 2018/10/14.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaDao areaDao;


    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
