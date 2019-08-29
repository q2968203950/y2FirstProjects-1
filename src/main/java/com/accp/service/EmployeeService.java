package com.accp.service;

import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Map<String, Object> findMap(Map<String, Object> map1);

    public int addPos(Employee employee);

    public int updatePos(Employee employee);

    public int deletePos(int empid);

    public Map<String, Object> findMapHis(Map<String, Object> map1);

    public List findAll(int deliveryspotid);

    public List findPname(int deliveryspotid);

}
