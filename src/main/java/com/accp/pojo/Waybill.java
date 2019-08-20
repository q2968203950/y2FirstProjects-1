package com.accp.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Waybill
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getInsureprice() {
        return insureprice;
    }

    public void setInsureprice(BigDecimal insureprice) {
        this.insureprice = insureprice;
    }

    public BigDecimal getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

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
