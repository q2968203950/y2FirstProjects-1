package com.accp.action;

import com.accp.service.UsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class UsersAction extends ActionSupport {


    private UsersService usersService;
    private String username;
    private String password;

    public UsersService getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 登录
     *
     * @return
     */
    @Override
    public String execute() throws Exception {
        Map<String,Object> map=null;
        boolean bool = usersService.getUsersAll(username, password);
        System.out.println(bool);
        System.out.println("username:"+username+""+"password:"+password);
        if (bool==true) {
            map= ActionContext.getContext().getSession();
            map.put("username",username);
            return super.execute();
        }
        return "error";
    }
}