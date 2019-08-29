package com.accp.service.impl;

import com.accp.dao.PowerDao;
import com.accp.service.PowerService;

import java.util.List;

public class PowerServiceImpl implements PowerService {
    private PowerDao powerDao;

    public void setPowerDao(PowerDao powerDao) {
        this.powerDao = powerDao;
    }

    @Override
    public List findAllP() {
        return this.powerDao.findAll();
    }
}
