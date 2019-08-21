package com.accp.pojo;


public class Positions {
    private int positidnid;
    private String pname;

    public int getPositidnid() {
        return positidnid;
    }

    public void setPositidnid(int positidnid) {
        this.positidnid = positidnid;
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

        Positions positions = (Positions) o;

        if (positidnid != positions.positidnid) return false;
        if (pname != null ? !pname.equals(positions.pname) : positions.pname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positidnid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        return result;
    }
}
