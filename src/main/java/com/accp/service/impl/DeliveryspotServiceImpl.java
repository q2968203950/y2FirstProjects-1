package com.accp.service.impl;

import com.accp.dao.DeliveryspotDao;
import com.accp.pojo.Deliveryspot;
import com.accp.service.DeliveryspotService;

import java.util.*;

public class DeliveryspotServiceImpl implements DeliveryspotService {
    private DeliveryspotDao deliveryspotDao;

    public void setDeliveryspotDao(DeliveryspotDao deliveryspotDao) {
        this.deliveryspotDao = deliveryspotDao;
    }

    @Override
    public Map<String, Object> findMap(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List list = this.deliveryspotDao.findDel(map1);
            map.put("data", list);
            long count = this.deliveryspotDao.count(map1);
            map.put("count", count);
            map.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "加载异常");
        }
        return map;
    }

    @Override
    public int addDel(Deliveryspot deliveryspot) {
        Random r = new Random();
        String deliveryspotno = "PS" + (r.nextInt(900000) + 100000);
        deliveryspot.setDeliveryspotno(deliveryspotno);
        return this.deliveryspotDao.addDel(deliveryspot);
    }

    @Override
    public int updateDel(Deliveryspot deliveryspot) {
        return this.deliveryspotDao.updateDel(deliveryspot);
    }

    @Override
    public int deleteDel(int deliveryspotid) {
        return this.deliveryspotDao.deleteDel(deliveryspotid);
    }

    @Override
    public int updateDelEmpId(int deliveryspotid, int empid) {
        return this.deliveryspotDao.updateDelEmpId(deliveryspotid, empid);
    }

    @Override
    public List findDelPName() {
        return this.deliveryspotDao.findDelPName();
    }
}
