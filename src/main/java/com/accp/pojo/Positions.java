package com.accp.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Positions
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
@Entity
public class Positions {
    private int positidnid;
    private String pname;

    @Id
    @Column(name = "POSITIDNID")
    public int getPositidnid() {
        return positidnid;
    }

    public void setPositidnid(int positidnid) {
        this.positidnid = positidnid;
    }

    @Basic
    @Column(name = "PNAME")
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
        return positidnid == positions.positidnid &&
                Objects.equals(pname, positions.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positidnid, pname);
    }
}
