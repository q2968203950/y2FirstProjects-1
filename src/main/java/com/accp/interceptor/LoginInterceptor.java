package com.accp.interceptor;

import com.accp.action.UsersAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object myAction = actionInvocation.getAction();
        if (myAction instanceof UsersAction) {
            return actionInvocation.invoke();

        } else {
            String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
            System.out.println(username);
            if (username == null) {
                System.out.println("用户未登录");
                return "error";
            } else {
                System.out.println("用户已登录");
                //放行
                return actionInvocation.invoke();
            }
        }
    }
}
