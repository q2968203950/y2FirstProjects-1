package com.accp.pojo;


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

        if (lineid != line.lineid) return false;
        if (lineno != line.lineno) return false;
        if (length != line.length) return false;
        if (linename != null ? !linename.equals(line.linename) : line.linename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lineid;
        result = 31 * result + lineno;
        result = 31 * result + (linename != null ? linename.hashCode() : 0);
        result = 31 * result + length;
        return result;
    }
}
