package com.accp.pojo;

import java.math.BigDecimal;
import java.sql.Date;

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

        if (id != waybill.id) return false;
        if (orderid != waybill.orderid) return false;
        if (deliveryspotid != waybill.deliveryspotid) return false;
        if (totalprice != null ? !totalprice.equals(waybill.totalprice) : waybill.totalprice != null) return false;
        if (insureprice != null ? !insureprice.equals(waybill.insureprice) : waybill.insureprice != null) return false;
        if (goodsprice != null ? !goodsprice.equals(waybill.goodsprice) : waybill.goodsprice != null) return false;
        if (volume != null ? !volume.equals(waybill.volume) : waybill.volume != null) return false;
        if (weight != null ? !weight.equals(waybill.weight) : waybill.weight != null) return false;
        if (remark != null ? !remark.equals(waybill.remark) : waybill.remark != null) return false;
        if (createtime != null ? !createtime.equals(waybill.createtime) : waybill.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderid;
        result = 31 * result + (totalprice != null ? totalprice.hashCode() : 0);
        result = 31 * result + (insureprice != null ? insureprice.hashCode() : 0);
        result = 31 * result + (goodsprice != null ? goodsprice.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + deliveryspotid;
        return result;
    }

    public Waybill() {
    }

    public Waybill(int orderid, BigDecimal totalprice, BigDecimal insureprice, BigDecimal goodsprice, BigDecimal volume, BigDecimal weight, String remark, Date createtime, int deliveryspotid) {
        this.orderid = orderid;
        this.totalprice = totalprice;
        this.insureprice = insureprice;
        this.goodsprice = goodsprice;
        this.volume = volume;
        this.weight = weight;
        this.remark = remark;
        this.createtime = createtime;
        this.deliveryspotid = deliveryspotid;
    }
}
