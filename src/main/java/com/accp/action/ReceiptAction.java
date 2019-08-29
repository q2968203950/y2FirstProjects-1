package com.accp.action;

import com.accp.pojo.Orders;
import com.accp.pojo.Receipt;
import com.accp.pojo.Receiptdetaile;
import com.accp.pojo.Waybill;
import com.accp.service.ReceiptService;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptAction extends ActionSupport {
    private ReceiptService receiptService;

    public void setReceiptService(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    private int empid;

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String findCarno() throws Exception {
        List list = this.receiptService.findCarno(empid);
        String json = JSON.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private String carno;
    private int deliveryspotid;
    private int empids;
    private String remark;
    private int flag;
    private String ptyoe;

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public void setEmpids(int empids) {
        this.empids = empids;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setPtyoe(String ptyoe) {
        this.ptyoe = ptyoe;
    }

    private int orderid;

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String addRec() throws Exception {
        Receipt receipt = new Receipt();
        receipt.setCarno(carno);
        receipt.setDeliveryspotid(deliveryspotid);
        receipt.setEmpid(empid);
        if (remark != null && !"".equals("")) {
            receipt.setRemark(remark);
        } else {
            receipt.setRemark("无");
        }
        receipt.setFlag(flag);
        receipt.setPtyoe(ptyoe);
        Receiptdetaile receiptdetaile = new Receiptdetaile();
        receiptdetaile.setOrderid(orderid);
        Map map = new HashMap();
        try {
            this.receiptService.addRec(receipt);
            this.receiptService.addRecDet(receiptdetaile);
            this.receiptService.updateOrdState(orderid);
            map.put("code", 0);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }
}
