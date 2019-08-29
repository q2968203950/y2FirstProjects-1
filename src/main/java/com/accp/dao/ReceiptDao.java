package com.accp.dao;

import com.accp.pojo.Receipt;
import com.accp.pojo.Receiptdetaile;

import java.util.List;

public interface ReceiptDao {
    /**
     * 根据员工id查询车牌号
     *
     * @param empid
     * @return
     */
    public List findCarno(int empid);

    /**
     * 添加交接单
     *
     * @param receipt
     * @return
     */
    public int addRec(Receipt receipt);

    /**
     * 查询ID
     *
     * @return
     */
    public int findRecId();

    /**
     * 添加Receiptdetaile表
     *
     * @param receiptdetaile
     * @return
     */
    public int addRecDet(Receiptdetaile receiptdetaile);

    /**
     * 根据订单id修改状态
     *
     * @param orderid
     * @return
     */
    public int updateOrdState(int orderid);
}
