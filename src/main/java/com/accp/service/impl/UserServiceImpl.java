package com.accp.service.impl;

import com.accp.dao.UserDao;
import com.accp.pojo.UserInfo;
import com.accp.pojo.UserLogin;
import com.accp.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean getPassWord(String userName, String passWord) {
        boolean b = false;
        List list = this.userDao.getPassword(userName);
        if(list != null || list.size() > 0){
            for (Object password: list ) {
                if (password.equals(passWord)){
                    return true;
                }
            }
        }
        return b;
    }

    @Override
    public int add(UserLogin userLogin) {
        return this.userDao.add(userLogin);
    }

    @Override
    public boolean checkUserName(String userName) {
        boolean b = false;
        List list = this.userDao.getPassword(userName);
        if(list.size() > 0){
            return b;
        }
        return true;
    }

    @Override
    public Map<String, Object> findMap(Map<String, Object> map1) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<UserInfo> list = this.userDao.findlist(map1);
            map.put("data", list);
            long count = this.userDao.count(map1);
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
    public int addUserInfo(UserInfo userInfo) {
        return this.userDao.addUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return this.userDao.updateUserInfo(userInfo);
    }
}
