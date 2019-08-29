package com.accp.service.impl;

import com.accp.dao.UserPowDao;
import com.accp.pojo.Users;
import com.accp.service.UserPowService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPowServiceImpl implements UserPowService {
    private UserPowDao userPowDao;

    public void setUserPowDao(UserPowDao userPowDao) {
        this.userPowDao = userPowDao;
    }

    @Override
    public Map<String, Object> findMap(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List list = this.userPowDao.findUsers(map1);
            map.put("data", list);
            long count = this.userPowDao.count(map1);
            map.put("count", count);
            map.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "加载异常");
        }
        return map;
    }

    @Override
    public int addUser(Users users) {
        return this.userPowDao.addUser(users);
    }

    @Override
    public int updateUser(String password, int userid) {
        return this.userPowDao.updateUser(password, userid);
    }

    @Override
    public int deleteUser(int userid) {
        return this.userPowDao.deleteUser(userid);
    }
}
