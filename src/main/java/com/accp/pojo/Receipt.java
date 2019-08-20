package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Receipt
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
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

    @Id
    @Column(name = "RECEIPTID")
    public int getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(int receiptid) {
        this.receiptid = receiptid;
    }

    @Basic
    @Column(name = "CARNO")
    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    @Basic
    @Column(name = "DELIVERYSPOTID")
    public Integer getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(Integer deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    @Basic
    @Column(name = "EMPID")
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Basic
    @Column(name = "CREATETIME")
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "FLAG")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "TONAME")
    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    @Basic
    @Column(name = "PTYOE")
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
