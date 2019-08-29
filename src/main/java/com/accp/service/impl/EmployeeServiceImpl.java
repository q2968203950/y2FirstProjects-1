package com.accp.service.impl;

import com.accp.dao.EmployeeDao;
import com.accp.pojo.Employee;
import com.accp.service.EmployeeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Map<String, Object> findMap(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List list = this.employeeDao.findEmp(map1);
            map.put("data", list);
            long count = this.employeeDao.count(map1);
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
    public int addPos(Employee employee) {
        Random r = new Random();
        String empno = "DE" + (r.nextInt(900000) + 100000);
        employee.setEmpno(empno);
        return this.employeeDao.addPos(employee);
    }

    @Override
    public int updatePos(Employee employee) {
        return this.employeeDao.updatePos(employee);
    }

    @Override
    public int deletePos(int empid) {
        return this.employeeDao.deletePos(empid);
    }

    @Override
    public Map<String, Object> findMapHis(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List list = this.employeeDao.findEmpHis(map1);
            map.put("data", list);
            long count = this.employeeDao.countHis(map1);
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
    public List findAll(int deliveryspotid) {
        return this.employeeDao.findAll(deliveryspotid);
    }

    @Override
    public List findPname(int deliveryspotid) {
        return this.employeeDao.findPname(deliveryspotid);
    }
}
