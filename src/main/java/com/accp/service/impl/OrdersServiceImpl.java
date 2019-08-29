package com.accp.service.impl;

import com.accp.dao.DeliveryspotDao;
import com.accp.dao.OrdersDao;
import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Orders;
import com.accp.pojo.Waybill;
import com.accp.service.OrdersService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrdersServiceImpl implements OrdersService {
    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    private DeliveryspotDao deliveryspotDao;

    public void setDeliveryspotDao(DeliveryspotDao deliveryspotDao) {
        this.deliveryspotDao = deliveryspotDao;
    }

    @Override
    public Map<String, Object> findMap(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List list = this.ordersDao.findOrd(map1);
            map.put("data", list);
            long count = this.ordersDao.count(map1);
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
    public List findState() {
        return this.ordersDao.findState();
    }

    @Override
    public int findOrdId(String orderno) {
        return 0;
    }

    private String orderno = null;

    @Override
    public int addOrd(Orders orders) {
        Random r = new Random();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
        orderno = "OD" + dateNowStr + (r.nextInt(90000000) + 10000000);
        orders.setOrderno(orderno);
        orders.setOrderstateid(this.ordersDao.findStateId("未处理"));
        Object newOrd = this.ordersDao.addOrd(orders);
        return 1;
    }

    @Override
    public int addWay(Waybill waybill) {
        waybill.setOrderid(this.ordersDao.findOrdId(orderno));
        Deliveryspot deliveryspot = this.deliveryspotDao.findDelC(waybill.getDeliveryspotid());
        if (deliveryspot.getStartscope().intValue() >= waybill.getWeight().intValue() && deliveryspot.getStartvolumescope().intValue() >= waybill.getVolume().intValue()) {
            waybill.setTotalprice(deliveryspot.getStartprice());
            System.out.println("1," + deliveryspot.getStartprice());
        } else if (deliveryspot.getStartscope().intValue() > waybill.getWeight().intValue() && deliveryspot.getStartvolumescope().intValue() < waybill.getVolume().intValue()) {
            int price = (waybill.getVolume().intValue() - deliveryspot.getStartvolumescope().intValue()) * deliveryspot.getSecondvdlumeprice().intValue();
            waybill.setTotalprice(new BigDecimal(deliveryspot.getStartprice().intValue() + price));
            System.out.println("2," + new BigDecimal(deliveryspot.getStartprice().intValue() + price));
        } else if (deliveryspot.getStartscope().intValue() < waybill.getWeight().intValue() && deliveryspot.getStartvolumescope().intValue() > waybill.getVolume().intValue()) {
            int price = (waybill.getWeight().intValue() - deliveryspot.getStartscope().intValue()) * deliveryspot.getSecondprice().intValue();
            waybill.setTotalprice(new BigDecimal(deliveryspot.getStartvolumeprice().intValue() + price));
            System.out.println("3," + new BigDecimal(deliveryspot.getStartvolumeprice().intValue() + price));
        } else if (deliveryspot.getStartscope().intValue() < waybill.getWeight().intValue() && deliveryspot.getStartvolumescope().intValue() < waybill.getVolume().intValue()) {
            int price = (waybill.getWeight().intValue() - deliveryspot.getStartscope().intValue()) * deliveryspot.getSecondprice().intValue();
            int prices = (waybill.getVolume().intValue() - deliveryspot.getStartvolumescope().intValue()) * deliveryspot.getSecondvdlumeprice().intValue();
            waybill.setTotalprice(new BigDecimal(deliveryspot.getStartprice().intValue() + price + prices));
            System.out.println("4," + new BigDecimal(deliveryspot.getStartprice().intValue() + price + prices));
        }
        waybill.setInsureprice(new BigDecimal(5));
        Date d = new Date();
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStrs = sdfs.format(d);
        try {
            Long date = sdfs.parse(dateNowStrs).getTime();
            waybill.setCreatetime(new java.sql.Date(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ordersDao.addWay(waybill);
        return 1;
    }

    @Override
    public List findOrdOne(int orderid) {
        return this.ordersDao.findOrdOne(orderid);
    }

}
