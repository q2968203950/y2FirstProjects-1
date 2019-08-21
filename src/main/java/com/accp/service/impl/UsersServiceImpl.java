package com.accp.service.impl;

import com.accp.dao.UsersDao;
import com.accp.dao.impl.UsersDaoImpl;
import com.accp.service.UsersService;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean getUsersAll(String username, String password) {
        return usersDao.getUsersAll(username,password);
    }

}
