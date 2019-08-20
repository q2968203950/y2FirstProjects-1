package com.accp.pojo;

import java.util.Objects;

/**
 * @program: y2FirstProjects
 * @description: Line
 * @author: hjn
 * @create: 2019-08-20 15:22
 **/
public class Line {
    private int lineid;
    private int lineno;
    private String linename;
    private int length;

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public int getLineno() {
        return lineno;
    }

    public void setLineno(int lineno) {
        this.lineno = lineno;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return lineid == line.lineid &&
                lineno == line.lineno &&
                length == line.length &&
                Objects.equals(linename, line.linename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineid, lineno, linename, length);
    }
}
