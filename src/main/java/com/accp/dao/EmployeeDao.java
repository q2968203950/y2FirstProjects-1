package com.accp.dao;

import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    /**
     * 查询员工信息
     *
     * @param map
     * @return
     */
    public List findEmp(Map<String, Object> map);

    /**
     * 查询总记录数
     *
     * @param map
     * @return
     */
    public long count(final Map<String, Object> map);

    /**
     * 添加员工信息
     *
     * @param employee
     * @return
     */
    public int addPos(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee
     * @return
     */
    public int updatePos(Employee employee);

    /**
     * 逻辑删除员工信息
     *
     * @param empid
     * @return
     */
    public int deletePos(int empid);

    /**
     * 查询离职员工信息
     *
     * @param map
     * @return
     */
    public List findEmpHis(Map<String, Object> map);

    /**
     * 查询离职总记录数
     *
     * @param map
     * @return
     */
    public long countHis(final Map<String, Object> map);

    /**
     * 查询所有员工信息
     *
     * @return
     */
    public List findAll(int deliveryspotids);

    /**
     * 根据ID查询司机
     *
     * @param deliveryspotid
     * @return
     */
    public List findPname(int deliveryspotid);
}
