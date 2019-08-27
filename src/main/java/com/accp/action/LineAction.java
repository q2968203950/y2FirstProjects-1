package com.accp.action;

import com.accp.pojo.Line;
import com.accp.service.LineService;
import com.accp.service.UsersService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class LineAction extends ActionSupport {
    private InputStream it;

    public LineService getLineService() {
        return lineService;
    }

    public void setLineService(LineService lineService) {
        this.lineService = lineService;
    }

    private LineService lineService;
    private String query;//搜索的值(名称)
    private String pwd;//搜索的值(密码)
    private int page; //当前页 ---ui自带
    private int rows;  //每页显示数 ---ui自带

    public InputStream getIt() {
        return it;
    }

    public void setIt(InputStream it) {
        this.it = it;
    }


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String execute() throws Exception {
        //获取json对象
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        JSONObject jb = null;
        int count = (page - 1) * rows;
        int sum = count + rows;
        List<Line> list = lineService.getLineAll();
        for(int i = count;i<sum && i<list.size();i++){
        jb = new JSONObject();
        jb.put("lineid",list.get(i).getLineid());
        jb.put("lineno",list.get(i).getLineno());
        jb.put("linename",list.get(i).getLinename());
        jb.put("length",list.get(i).getLength());
        ja.add(jb);
            System.out.println("jb"+jb);
        }
        jo.put("total",list.size());
        jo.put("rows",ja);
        it = new ByteArrayInputStream(jo.toString().getBytes("utf-8"));
        return super.execute();
    }
}
