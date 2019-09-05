package com.accp.service.impl;

import com.accp.dao.LineDao;
import com.accp.pojo.Line;
import com.accp.service.LineService;

import java.util.List;

public class LineServiceImpl implements LineService {
    private LineDao lineDao;

    /**
     * 查询所有线路信息
     * @return
     */
    @Override
    public List<Line> getLineAll() {
        return lineDao.getLineAll();
    }
}
