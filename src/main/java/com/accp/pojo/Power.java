package com.accp.pojo;


public class Power {
    private int powerid;
    private String pname;

    public int getPowerid() {
        return powerid;
    }

    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Power power = (Power) o;

        if (powerid != power.powerid) return false;
        if (pname != null ? !pname.equals(power.pname) : power.pname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = powerid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        return result;
    }
}
