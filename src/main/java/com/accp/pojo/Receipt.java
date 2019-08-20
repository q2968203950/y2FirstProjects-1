package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Receipt
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
public class Receipt {
    private int receiptid;
    private String carno;
    private Integer deliveryspotid;
    private Integer empid;
    private String createtime;
    private String remark;
    private Integer flag;
    private String toname;
    private String ptyoe;

    public int getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(int receiptid) {
        this.receiptid = receiptid;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public Integer getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(Integer deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getPtyoe() {
        return ptyoe;
    }

    public void setPtyoe(String ptyoe) {
        this.ptyoe = ptyoe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return receiptid == receipt.receiptid &&
                Objects.equals(carno, receipt.carno) &&
                Objects.equals(deliveryspotid, receipt.deliveryspotid) &&
                Objects.equals(empid, receipt.empid) &&
                Objects.equals(createtime, receipt.createtime) &&
                Objects.equals(remark, receipt.remark) &&
                Objects.equals(flag, receipt.flag) &&
                Objects.equals(toname, receipt.toname) &&
                Objects.equals(ptyoe, receipt.ptyoe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptid, carno, deliveryspotid, empid, createtime, remark, flag, toname, ptyoe);
    }
}
