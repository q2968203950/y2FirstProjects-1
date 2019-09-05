package com.accp.service.impl;

import com.accp.dao.PositionsDao;
import com.accp.service.PositionsService;

import java.util.List;

public class PositionsServiceImpl implements PositionsService {
    private PositionsDao positionsDao;

    public void setPositionsDao(PositionsDao positionsDao) {
        this.positionsDao = positionsDao;
    }

    @Override
    public List findPos() {
        return this.positionsDao.findPos();
    }
}
