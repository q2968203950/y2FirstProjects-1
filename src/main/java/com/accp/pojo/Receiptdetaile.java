package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Receiptdetaile
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Receiptdetaile {
    private int rdid;
    private Integer receiptid;
    private Integer orderid;

    @Id
    @Column(name = "RDID")
    public int getRdid() {
        return rdid;
    }

    public void setRdid(int rdid) {
        this.rdid = rdid;
    }

    @Basic
    @Column(name = "RECEIPTID")
    public Integer getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(Integer receiptid) {
        this.receiptid = receiptid;
    }

    @Basic
    @Column(name = "ORDERID")
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiptdetaile that = (Receiptdetaile) o;
        return rdid == that.rdid &&
                Objects.equals(receiptid, that.receiptid) &&
                Objects.equals(orderid, that.orderid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rdid, receiptid, orderid);
    }
}
