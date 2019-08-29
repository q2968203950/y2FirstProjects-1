package com.accp.service.impl;

import com.accp.dao.ReceiptDao;
import com.accp.pojo.Receipt;
import com.accp.pojo.Receiptdetaile;
import com.accp.service.ReceiptService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptDao receiptDao;

    public void setReceiptDao(ReceiptDao receiptDao) {
        this.receiptDao = receiptDao;
    }

    @Override
    public List findCarno(int empid) {
        return this.receiptDao.findCarno(empid);
    }

    @Override
    public int addRec(Receipt receipt) {
        Date d = new Date();
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStrs = sdfs.format(d);
        receipt.setCreatetime(dateNowStrs);
        receipt.setToname("无");
        return this.receiptDao.addRec(receipt);
    }

    @Override
    public int addRecDet(Receiptdetaile receiptdetaile) {
        receiptdetaile.setReceiptid(this.receiptDao.findRecId());
        return this.receiptDao.addRecDet(receiptdetaile);
    }

    @Override
    public int updateOrdState(int orderid) {
        return this.receiptDao.updateOrdState(orderid);
    }
}
