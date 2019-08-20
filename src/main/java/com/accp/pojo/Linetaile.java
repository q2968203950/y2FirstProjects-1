package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Linetaile
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
public class Linetaile {
    private int linedetaileid;
    private int lineid;
    private int deliveryspotid;
    private int lineindex;

    public int getLinedetaileid() {
        return linedetaileid;
    }

    public void setLinedetaileid(int linedetaileid) {
        this.linedetaileid = linedetaileid;
    }

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public int getDeliveryspotid() {
        return deliveryspotid;
    }

    public void setDeliveryspotid(int deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public int getLineindex() {
        return lineindex;
    }

    public void setLineindex(int lineindex) {
        this.lineindex = lineindex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linetaile linetaile = (Linetaile) o;
        return linedetaileid == linetaile.linedetaileid &&
                lineid == linetaile.lineid &&
                deliveryspotid == linetaile.deliveryspotid &&
                lineindex == linetaile.lineindex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linedetaileid, lineid, deliveryspotid, lineindex);
    }
}
