package com.accp.service.impl;

import com.accp.dao.CityDao;
import com.accp.pojo.City;
import com.accp.pojo.Province;
import com.accp.service.CityService;

import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDao cityDao;

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List getProvince() {
        return this.cityDao.getProvince();
    }

    @Override
    public List getCity(int provinced) {
        return this.cityDao.getCity(provinced);
    }
}
