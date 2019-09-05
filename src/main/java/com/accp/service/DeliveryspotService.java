package com.accp.service;

import com.accp.pojo.Deliveryspot;

import java.util.List;
import java.util.Map;

public interface DeliveryspotService {
    public Map<String, Object> findMap(Map<String, Object> map1);

    public int addDel(Deliveryspot deliveryspot);

    public int updateDel(Deliveryspot deliveryspot);

    public int deleteDel(int deliveryspotid);

    public int updateDelEmpId(int deliveryspotid, int empid);

    public List findDelPName();
}
