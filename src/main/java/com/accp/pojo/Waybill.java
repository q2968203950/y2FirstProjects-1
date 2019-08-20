package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Waybill
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Waybill {
    private int id;
    private int orderid;
    private BigDecimal totalprice;
    private BigDecimal insureprice;
    private BigDecimal goodsprice;
    private BigDecimal volume;
    private BigDecimal weight;
    private String remark;
    private Date createtime;
    private int deliveryspotid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORDERID")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "TOTALPRICE")
    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    @Basic
    @Column(name = "INSUREPRICE")
    public BigDecimal getInsureprice() {
        return insureprice;
    }

    public void setInsureprice(BigDecimal insureprice) {
        this.insureprice = insureprice;
    }

    @Basic
    @Column(name = "GOODSPRICE")
    public BigDecimal getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    @Basic
    @Column(name = "VOLUME")
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "WEIGHT")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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
    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "DELIVERYSPOTID")
    public int getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waybill waybill = (Waybill) o;
        return id == waybill.id &&
                orderid == waybill.orderid &&
                deliveryspotid == waybill.deliveryspotid &&
                Objects.equals(totalprice, waybill.totalprice) &&
                Objects.equals(insureprice, waybill.insureprice) &&
                Objects.equals(goodsprice, waybill.goodsprice) &&
                Objects.equals(volume, waybill.volume) &&
                Objects.equals(weight, waybill.weight) &&
                Objects.equals(remark, waybill.remark) &&
                Objects.equals(createtime, waybill.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderid, totalprice, insureprice, goodsprice, volume, weight, remark, createtime, deliveryspotid);
    }
}
