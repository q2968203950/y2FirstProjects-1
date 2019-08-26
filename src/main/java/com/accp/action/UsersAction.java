package com.accp.action;

import com.accp.pojo.Users;
import com.accp.service.UsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UsersAction extends ActionSupport {


    private UsersService usersService;
    private String username;
    private String password;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    private Users users;
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
        users = new Users(username,password);
        System.out.println(username);
        System.out.println(password);
        boolean list = usersService.getUsersAll(username,password);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        System.out.println(list);
        if(list){
            session.setAttribute("username",username);
            return super.execute();
        }
        return "error";
//        Map<String,Object> map=null;
//        boolean bool = usersService.getUsersAll(username, password);
//        System.out.println(bool);
//        System.out.println("username:"+username+""+"password:"+password);
//        if (bool==true) {
//            map= ActionContext.getContext().getSession();
//            map.put("username",username);
//            return super.execute();
//        }
//        return "error";
    }
    /**
     * 用户名销毁
     * @return
     */
    public void sessionInvalidate() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println("注销成功");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.html");

    }
}