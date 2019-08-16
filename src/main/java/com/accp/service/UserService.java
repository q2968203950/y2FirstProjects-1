package com.accp.service;

import com.accp.pojo.UserInfo;
import com.accp.pojo.UserLogin;

import java.util.Map;

public interface UserService {
    /**
     * 判断是否与数据库中的密码是否相等
     * @param userName
     * @param passWord
     * @return
     */
    public boolean getPassWord(String userName, String passWord);

    /**
     * 注册
     * @param userLogin
     * @return
     */
    public int add(UserLogin userLogin);

    /**
     * 验证用户名
     * @param userName
     * @return
     */
    public boolean checkUserName(String userName);

    /**
     * 分页查询
     * @param map1
     * @return
     */
    public Map<String, Object> findMap(Map<String, Object> map1);

    /**
     * 添加
     * @param userInfo
     * @return
     */
    public int addUserInfo(UserInfo userInfo);

    /**
     * 修改
     * @param userInfo
     * @return
     */
    public int updateUserInfo(UserInfo userInfo);
}
