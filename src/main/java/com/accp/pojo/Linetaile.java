package com.accp.pojo;


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

        if (linedetaileid != linetaile.linedetaileid) return false;
        if (lineid != linetaile.lineid) return false;
        if (deliveryspotid != linetaile.deliveryspotid) return false;
        if (lineindex != linetaile.lineindex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linedetaileid;
        result = 31 * result + lineid;
        result = 31 * result + deliveryspotid;
        result = 31 * result + lineindex;
        return result;
    }
}
