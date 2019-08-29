package com.accp.dao;

import com.accp.pojo.City;
import com.accp.pojo.Province;

import java.util.List;

public interface CityDao {
    /**
     * 查询省的数据
     *
     * @return
     */
    public List<Province> getProvince();

    /**
     * 查询市的数据
     * @return
     */
    public List<City> getCity(int provinced);
}
