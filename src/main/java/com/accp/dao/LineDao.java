package com.accp.dao;

import com.accp.pojo.Line;

import java.util.List;

public interface LineDao {
    /**
     * 查询所有的线路信息
     * @return
     */
    public List<Line> getLineAll();
}
