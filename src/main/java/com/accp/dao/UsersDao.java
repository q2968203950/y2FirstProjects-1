package com.accp.dao;

public interface UsersDao {
    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    public boolean getUsersAll(String username,String password);
}
