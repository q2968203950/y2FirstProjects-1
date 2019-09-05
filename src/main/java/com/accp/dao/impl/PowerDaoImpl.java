package com.accp.dao.impl;

import com.accp.dao.PowerDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;

public class PowerDaoImpl implements PowerDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findAll() {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("SELECT * FROM power ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List list = query.list();
                return list;
            }
        });
        return list;
    }
}
