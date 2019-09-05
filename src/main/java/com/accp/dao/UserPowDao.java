package com.accp.dao;

import com.accp.pojo.Users;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Map;

public interface UserPowDao {
    /**
     * 用户分页查询
     *
     * @param map
     * @return
     */
    public List findUsers(final Map<String, Object> map);

    /**
     * 查询总记录数
     *
     * @param map
     * @return
     */
    public long count(final Map<String, Object> map);

    /**
     * 添加用户信息
     *
     * @param users
     * @return
     */
    public int addUser(Users users);

    /**
     * 根据用户id更改密码
     *
     * @param password
     * @param userid
     * @return
     */
    public int updateUser(String password, int userid);

    /**
     * 根据用户id删除该数据
     *
     * @param userid
     * @return
     */
    public int deleteUser(int userid);
}
