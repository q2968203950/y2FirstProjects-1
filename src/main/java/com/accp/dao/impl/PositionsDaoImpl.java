package com.accp.dao.impl;

import com.accp.dao.PositionsDao;
import com.accp.pojo.Positions;
import com.accp.pojo.Province;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;

public class PositionsDaoImpl implements PositionsDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findPos() {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List<Province>>() {
            @Override
            public List<Province> doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT * FROM positions;";
                Query query = session.createSQLQuery(sql).addEntity(Positions.class);
                List list = query.list();
                return list;
            }
        });
        return list;
    }
}
