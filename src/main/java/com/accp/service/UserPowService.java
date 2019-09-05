package com.accp.service;

import com.accp.pojo.Users;

import java.util.Map;

public interface UserPowService {
    public Map<String, Object> findMap(Map<String, Object> map1);

    public int addUser(Users users);

    public int updateUser(String password, int userid);

    public int deleteUser(int userid);
}
