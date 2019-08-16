package com.accp.dao;

import com.accp.pojo.UserInfo;
import com.accp.pojo.UserLogin;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 登录
     *
     * @param userName
     * @return
     */
    public List getPassword(String userName);

    /**
     * 注册
     *
     * @param userLogin
     * @return
     */
    public int add(UserLogin userLogin);

    /**
     * 分页查询
     * 模糊查询
     * @param map
     * @return
     */
    public List<UserInfo> findlist(final Map<String, Object> map);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    public long count(Map<String, Object> map);

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
