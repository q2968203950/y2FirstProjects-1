package com.accp.dao.impl;

import com.accp.dao.UserDao;
import com.accp.pojo.UserInfo;
import com.accp.pojo.UserLogin;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List getPassword(String userName) {
        String hql = "select u.passWord from UserLogin u where u.userName = ?";
        List list = this.hibernateTemplate.find(hql, userName);
        return list;
    }

    @Override
    public int add(UserLogin userLogin) {
        int count = (int) this.hibernateTemplate.save(userLogin);
        return count;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserInfo> findlist(final Map<String, Object> map) {
        List<UserInfo> list = (List<UserInfo>) this.hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("from UserInfo u where 1=1");
                if(map.containsKey("userName")){
                    sbf.append(" and u.userName like :userName");
                }
                if(map.containsKey("sex")){
                    sbf.append(" and u.sex like :sex");
                }
                if(map.containsKey("deptName")){
                    sbf.append(" and u.deptName like :deptName");
                }
                Query query = session.createQuery(sbf.toString());
                query.setProperties(map);
                int page = (int) map.get("page");
                int limit = (int) map.get("limit");
                query.setFirstResult((page-1)*limit);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public long count(final Map<String, Object> map) {
        long count = (long) this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                StringBuffer sbf = new StringBuffer("select count(u.userId) from UserInfo u where 1=1");
                if(map.containsKey("userName")){
                    sbf.append(" and u.userName like :userName");
                }
                if(map.containsKey("sex")){
                    sbf.append(" and u.sex like :sex");
                }
                if(map.containsKey("deptName")){
                    sbf.append(" and u.deptName like :deptName");
                }
                Query query = session.createQuery(sbf.toString());
                query.setProperties(map);
                return query.uniqueResult();
            }
        });
        return count;
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return (int)this.hibernateTemplate.save(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        this.hibernateTemplate.update(userInfo);
        return 1;
    }
}
