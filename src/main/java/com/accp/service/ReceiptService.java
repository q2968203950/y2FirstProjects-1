package com.accp.service;

import com.accp.dao.ReceiptDao;
import com.accp.pojo.Receipt;
import com.accp.pojo.Receiptdetaile;

import java.util.List;

public interface ReceiptService {
    public List findCarno(final int empid);

    public int addRec(Receipt receipt);

    public int addRecDet(Receiptdetaile receiptdetaile);

    public int updateOrdState(int orderid);
}
