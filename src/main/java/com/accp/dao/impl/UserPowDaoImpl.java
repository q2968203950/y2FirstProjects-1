package com.accp.dao.impl;

import com.accp.dao.UserPowDao;
import com.accp.pojo.Users;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserPowDaoImpl implements UserPowDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findUsers(final Map<String, Object> map) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("SELECT u.USERID,u.USERNAME,u.POWERID,p.PNAME,u.DELIVERYSPOTID,\n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname,\n" +
                        "u.EMPID,e.EMPNO,e.ENAME\n" +
                        "FROM users u,power p,deliveryspot d,employee e\n" +
                        "where u.POWERID = p.POWERID and u.DELIVERYSPOTID = d.DELIVERYSPOTID and u.EMPID = e.EMPID ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                int page = (int) map.get("page");
                int limit = (int) map.get("limit");
                query.setFirstResult((page - 1) * limit);
                query.setMaxResults(limit);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public long count(Map<String, Object> map) {
        Long count = Long.parseLong(this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                StringBuffer sbf = new StringBuffer("select count(uu.USERID) from(SELECT u.USERID,u.USERNAME,u.POWERID,p.PNAME,u.DELIVERYSPOTID,\n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname,\n" +
                        "u.EMPID,e.EMPNO,e.ENAME\n" +
                        "FROM users u,power p,deliveryspot d,employee e\n" +
                        "where u.POWERID = p.POWERID and u.DELIVERYSPOTID = d.DELIVERYSPOTID and u.EMPID = e.EMPID) uu ");
                Query query = session.createSQLQuery(sbf.toString());
                return query.uniqueResult();
            }
        }).toString());
        return count;
    }

    @Override
    public int addUser(Users users) {
        return (int) this.hibernateTemplate.save(users);
    }

    @Override
    public int updateUser(String password, int userid) {
        Users users = this.hibernateTemplate.get(Users.class, userid);
        users.setPassowrd(password);
        this.hibernateTemplate.update(users);
        return 1;
    }

    @Override
    public int deleteUser(int userid) {
        Users users = this.hibernateTemplate.get(Users.class, userid);
        this.hibernateTemplate.delete(users);
        return 1;
    }
}
