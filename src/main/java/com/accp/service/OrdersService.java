package com.accp.service;

import com.accp.pojo.Orders;
import com.accp.pojo.Waybill;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    public Map<String, Object> findMap(Map<String, Object> map1);

    public List findState();

    public int addOrd(Orders orders);

    public int findOrdId(String orderno);

    public int addWay(Waybill waybill);

    public List findOrdOne(int orderid);
}
