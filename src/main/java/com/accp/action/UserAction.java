package com.accp.action;

import com.accp.pojo.UserInfo;
import com.accp.pojo.UserLogin;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.accp.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class UserAction extends ActionSupport {
    private UserService userService;
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        boolean result= this.userService.getPassWord(userName,passWord);
        if(result){
            return super.execute();
        }else{
            return INPUT;
        }
    }

    public String checkUserName() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        boolean result= this.userService.checkUserName(userName);
        response.getWriter().print(JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect));
        return null;
    }

    public String register() throws Exception {
        UserLogin user = new UserLogin(userName,passWord);
        int count = this.userService.add(user);
        if(count > 0){
            return INPUT;
        }
        return null;
    }

    private int page = 1;
    private int limit = 10;
    private String userInfoName;
    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public String page() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("limit", limit);
        if(userInfoName != null && !userInfoName.equals("")){
            map.put("userName", "%"+userInfoName+"%");
        }
        if(sex != null && !sex.equals("")){
            map.put("sex", "%"+sex+"%");
        }
        if(deptName != null && !deptName.equals("")){
            map.put("deptName", "%"+deptName+"%");
        }
        Map<String, Object> map1 = this.userService.findMap(map);
        String json = JSON.toJSONString(map1);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(json);
        return null;
    }

    private Integer userId;
    private String sex;
    private Integer age;
    private Date birthday;
    private String deptName;
    private BigDecimal sal;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public String addUserInfo()throws Exception{
        UserInfo userInfo = new UserInfo(userName,sex,age,birthday,deptName,sal);
        Map<String, Object> m = new HashMap<>();
        try {
            this.userService.addUserInfo(userInfo);
            m.put("code", 0);
            m.put("msg", "添加成功...");
        }catch (Exception e) {
            e.printStackTrace();
            m.put("code", -1);
            m.put("msg", "添加失败...");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(m));
        return null;
    }

    public String updateUserInfo()throws Exception{
        UserInfo userInfo = new UserInfo(userId,userName,sex,age,birthday,deptName,sal);
        Map<String, Object> map = new HashMap<>();
        try {
            this.userService.updateUserInfo(userInfo);
            map.put("code", 0);
            map.put("msg", "修改成功...");
        }catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "修改失败...");
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("json/application;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));
        return null;
    }

}
