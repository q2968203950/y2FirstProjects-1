package com.accp.pojo;


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

        if (receiptid != receipt.receiptid) return false;
        if (carno != null ? !carno.equals(receipt.carno) : receipt.carno != null) return false;
        if (deliveryspotid != null ? !deliveryspotid.equals(receipt.deliveryspotid) : receipt.deliveryspotid != null)
            return false;
        if (empid != null ? !empid.equals(receipt.empid) : receipt.empid != null) return false;
        if (createtime != null ? !createtime.equals(receipt.createtime) : receipt.createtime != null) return false;
        if (remark != null ? !remark.equals(receipt.remark) : receipt.remark != null) return false;
        if (flag != null ? !flag.equals(receipt.flag) : receipt.flag != null) return false;
        if (toname != null ? !toname.equals(receipt.toname) : receipt.toname != null) return false;
        if (ptyoe != null ? !ptyoe.equals(receipt.ptyoe) : receipt.ptyoe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = receiptid;
        result = 31 * result + (carno != null ? carno.hashCode() : 0);
        result = 31 * result + (deliveryspotid != null ? deliveryspotid.hashCode() : 0);
        result = 31 * result + (empid != null ? empid.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (toname != null ? toname.hashCode() : 0);
        result = 31 * result + (ptyoe != null ? ptyoe.hashCode() : 0);
        return result;
    }
}
