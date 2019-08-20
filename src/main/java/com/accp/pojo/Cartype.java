package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Cartype
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Cartype {
    private int cartypeid;
    private String tname;

    @Id
    @Column(name = "CARTYPEID")
    public int getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(int cartypeid) {
        this.cartypeid = cartypeid;
    }

    @Basic
    @Column(name = "TNAME")
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
        return cartypeid == cartype.cartypeid &&
                Objects.equals(tname, cartype.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartypeid, tname);
    }
}
