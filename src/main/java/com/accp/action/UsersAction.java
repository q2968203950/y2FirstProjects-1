package com.accp.action;

import com.accp.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UsersAction extends ActionSupport {
    //重定向
    private HttpServletResponse response = ServletActionContext.getResponse();

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    //转发
    private HttpServletRequest request = ServletActionContext.getRequest();
    //会话
    private HttpSession session = request.getSession();
    private UsersService usersService;
    private String username;
    private String password;

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public UsersService getUsersService() {
        return usersService;
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
     * @return
     */
    public String getLogin(){
        boolean bool = usersService.getUsersAll(username, password);
        System.out.println(bool);
        System.out.println(username+""+password);
        if(bool){
            session.setAttribute("username",username);
            return "success";
        }
        return "error";
    }
    /**
     * 用户名销毁
     * @return
     */
    public void sessionInvalidate() throws IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("销毁");
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
