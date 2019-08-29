package com.accp.action;

import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Users;
import com.accp.service.UserPowService;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class UserPowAction extends ActionSupport {
    private UserPowService userPowService;

    public void setUserPowService(UserPowService userPowService) {
        this.userPowService = userPowService;
    }

    private int page = 1;
    private int limit = 10;

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String findEmp() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        Map<String, Object> map1 = this.userPowService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private int userid;
    private String username;
    private String passowrd;
    private Integer powerid;
    private Integer deliveryspotid;
    private int empid;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public void setDeliveryspotid(Integer deliveryspotid) {
        this.deliveryspotid = deliveryspotid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String addUser() throws Exception {
        Map map = new HashMap();
        Users users = new Users();
        users.setUsername(username);
        users.setPassowrd(passowrd);
        users.setPowerid(powerid);
        users.setDeliveryspotid(deliveryspotid);
        users.setEmpid(empid);
        try {
            int count = this.userPowService.addUser(users);
            map.put("code", 0);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "添加失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

    public String updateUser() throws Exception {
        Map map = new HashMap();
        try {
            int count = this.userPowService.updateUser(passowrd, userid);
            map.put("code", 0);
            map.put("msg", "修改成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "修改失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

    public String deleteUser() throws Exception {
        Map map = new HashMap();
        try {
            int count = this.userPowService.deleteUser(userid);
            map.put("code", 0);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            map.put("code", -1);
            map.put("msg", "删除失败");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }
}
