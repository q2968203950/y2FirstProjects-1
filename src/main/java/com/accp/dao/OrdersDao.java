package com.accp.dao;

import com.accp.pojo.Orders;
import com.accp.pojo.Waybill;

import java.util.List;
import java.util.Map;

public interface OrdersDao {
    /**
     * 分页查询订单
     *
     * @param map
     * @return
     */
    public List findOrd(final Map<String, Object> map);

    /**
     * 查询总记录数
     *
     * @param map
     * @return
     */
    public long count(final Map<String, Object> map);

    /**
     * 查询订单所有状态
     *
     * @return
     */
    public List findState();

    /**
     * 根据状态名称查询ID
     *
     * @param oname
     * @return
     */
    public int findStateId(String oname);

    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    public int addOrd(Orders orders);

    /**
     * 添加订单
     *
     * @param waybill
     * @return
     */
    public int addWay(Waybill waybill);

    /**
     * 根据订单号查询订单ID
     *
     * @param orderno
     * @return
     */
    public int findOrdId(String orderno);

    /**
     * 根据订单ID查询数据
     *
     * @param orderid
     * @return
     */
    public List findOrdOne(int orderid);
}
