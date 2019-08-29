package com.accp.dao.impl;

import com.accp.dao.DeliveryspotDao;
import com.accp.pojo.City;
import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Province;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DeliveryspotDaoImpl implements DeliveryspotDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findDel(final Map<String, Object> map) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select * from (select d.DELIVERYSPOTID,d.DELIVERYSPOTNO,d.DNAME,\n" +
                        " (select p.PNAME from province p where p.PROVINCED = d.PROVINCEID) pname,\n" +
                        " (select c.cname from city c where c.CITYID = d.CITYID) cname,\n" +
                        " d.TEL, d.EMPID,\n" +
                        " (select e.EMPNO from employee e where e.EMPID = d.EMPID and e.DELIVERYSPOTID = d.DELIVERYSPOTID) empno,\n" +
                        " d.STARTSCOPE,d.STARTPRICE,d.SECONDPRICE,d.FLAG,d.STARTVOLUMESCOPE,d.STARTVOLUMEPRICE,d.SECONDVDLUMEPRICE\n" +
                        " from deliveryspot d where d.FLAG = 0) dd\n" +
                        " where 1 = 1 ");
                if (map.containsKey("pname")) {
                    sbf.append(" and dd.pname like :pname");
                }
                if (map.containsKey("cname")) {
                    sbf.append(" and dd.cname like :cname");
                }
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                query.setProperties(map);
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

    @SuppressWarnings("unchecked")
    @Override
    public long count(final Map<String, Object> map) {
        Long count = Long.parseLong(this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                StringBuffer sbf = new StringBuffer("select count(dd.DELIVERYSPOTID) from (select d.*, \n" +
                        "(select p.PNAME from province p where p.PROVINCED = d.PROVINCEID) pname,\n" +
                        "(select c.cname from city c where c.CITYID = d.CITYID) cname \n" +
                        "from deliveryspot d) dd\n" +
                        "where 1 = 1 ");
                if (map.containsKey("pname")) {
                    sbf.append(" and dd.pname like :pname");
                }
                if (map.containsKey("cname")) {
                    sbf.append(" and dd.cname like :cname");
                }
                Query query = session.createSQLQuery(sbf.toString());
                query.setProperties(map);
                return query.uniqueResult();
            }
        }).toString());
        return count;
    }

    @Override
    public int addDel(Deliveryspot deliveryspot) {
        return (int) this.hibernateTemplate.save(deliveryspot);
    }

    @Override
    public int updateDel(Deliveryspot deliveryspot) {
        this.hibernateTemplate.update(deliveryspot);
        return 1;
    }

    @Override
    public int deleteDel(int deliveryspotid) {
        Deliveryspot deliveryspot = this.hibernateTemplate.get(Deliveryspot.class, deliveryspotid);
        deliveryspot.setFlag(1);
        this.hibernateTemplate.update(deliveryspot);
        return 1;
    }

    @Override
    public int updateDelEmpId(int deliveryspotid, int empid) {
        Deliveryspot deliveryspot = this.hibernateTemplate.get(Deliveryspot.class, deliveryspotid);
        deliveryspot.setEmpid(empid);
        this.hibernateTemplate.update(deliveryspot);
        return 1;
    }

    @Override
    public List findDelPName() {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select * from (select d.DELIVERYSPOTID,d.DELIVERYSPOTNO,d.DNAME,\n" +
                        " (select p.PNAME from province p where p.PROVINCED = d.PROVINCEID) pname,\n" +
                        " (select c.cname from city c where c.CITYID = d.CITYID) cname,\n" +
                        " d.TEL, d.EMPID,\n" +
                        " (select e.EMPNO from employee e where e.EMPID = d.EMPID and e.DELIVERYSPOTID = d.DELIVERYSPOTID) empno,\n" +
                        " d.STARTSCOPE,d.STARTPRICE,d.SECONDPRICE,d.FLAG,d.STARTVOLUMESCOPE,d.STARTVOLUMEPRICE,d.SECONDVDLUMEPRICE\n" +
                        " from deliveryspot d where d.FLAG = 0) dd\n" +
                        " where 1 = 1 ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public Deliveryspot findDelC(final int deliveryspotid) {
        Deliveryspot deliveryspot = this.hibernateTemplate.execute(new HibernateCallback<Deliveryspot>() {
            @Override
            public Deliveryspot doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT * FROM logistics.deliveryspot d where d.DELIVERYSPOTID = :deliveryspotid ";
                Query query = session.createSQLQuery(sql).addEntity(Deliveryspot.class);
                query.setInteger("deliveryspotid", deliveryspotid);
                return (Deliveryspot) query.uniqueResult();
            }
        });
        return deliveryspot;
    }
}
