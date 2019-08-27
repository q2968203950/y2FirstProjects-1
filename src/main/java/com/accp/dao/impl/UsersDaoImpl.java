package com.accp.dao.impl;

import com.accp.dao.UsersDao;
import com.accp.pojo.Users;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;
@SuppressWarnings("all")
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {
    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean getUsersAll(String username, String password) {
        boolean restu=false;
        String hql = "from Users where username = ? and passowrd = ?";
        List<Users> list =(List<Users>)this.getHibernateTemplate().find(hql, username, password);
        if(list.size()>0){
            restu = true;
        }
        return restu;
    }
}
