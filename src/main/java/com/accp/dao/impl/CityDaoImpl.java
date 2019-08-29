package com.accp.dao.impl;

import com.accp.dao.CityDao;
import com.accp.pojo.City;
import com.accp.pojo.Province;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements CityDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Province> getProvince() {
        List<Province> list = this.hibernateTemplate.execute(new HibernateCallback<List<Province>>() {
            @Override
            public List<Province> doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT * FROM province";
                Query query = session.createSQLQuery(sql).addEntity(Province.class);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> getCity(final int provinced) {
        List<City> list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT * FROM city c where c.PROVINCEID = :provinced";
                Query query = session.createSQLQuery(sql).addEntity(City.class);
                query.setInteger("provinced",provinced);
                List list = query.list();
                return list;
            }
        });
        return list;
    }
}
