package com.accp.pojo;


public class Cartype {
    private int cartypeid;
    private String tname;

    public int getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(int cartypeid) {
        this.cartypeid = cartypeid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartype cartype = (Cartype) o;

        if (cartypeid != cartype.cartypeid) return false;
        if (tname != null ? !tname.equals(cartype.tname) : cartype.tname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartypeid;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        return result;
    }
}
