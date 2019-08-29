package com.accp.dao.impl;

import com.accp.dao.OrdersDao;
import com.accp.pojo.Deliveryspot;
import com.accp.pojo.Orders;
import com.accp.pojo.Waybill;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrdersDaoImpl implements OrdersDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findOrd(final Map<String, Object> map) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select o.ORDERID,o.ORDERNO,o.SENDNAME,o.SENDADDRESS,o.SENDTEL,o.SENDMOBTLE,o.SENDPOSTCODE,\n" +
                        "o.RECEIVENAME,o.RECEIVEADDRESS,o.RECEIVETEL,o.RECEIVEMODILE,o.RECEIVEPOSTCODE,o.ORDERSTATEID,\n" +
                        "(select os.ONAME from orderstate os where os.ORDERSTATEID = o.ORDERSTATEID) oname,\n" +
                        "w.TOTALPRICE,w.INSUREPRICE,w.GOODSPRICE,w.VOLUME,w.WEIGHT,w.REMARK,w.CREATETIME,w.DELIVERYSPOTID\n" +
                        "from orders o,waybill w\n" +
                        "where o.ORDERID = w.ORDERID ");
                if (map.containsKey("deliveryspotid")) {
                    sbf.append(" and w.DELIVERYSPOTID = :deliveryspotid");
                }
                if (map.containsKey("orderno")) {
                    sbf.append(" and o.ORDERNO like :orderno");
                }
                if (map.containsKey("orderstateid")) {
                    sbf.append(" and o.ORDERSTATEID = :orderstateid");
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

    @Override
    public long count(final Map<String, Object> map) {
        Long count = Long.parseLong(this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                StringBuffer sbf = new StringBuffer("select count(w.id) from orders o,waybill w\n" +
                        "where o.ORDERID = w.ORDERID ");
                if (map.containsKey("deliveryspotid")) {
                    sbf.append(" and w.DELIVERYSPOTID = :deliveryspotid");
                }
                if (map.containsKey("orderno")) {
                    sbf.append(" and o.ORDERNO like :orderno");
                }
                if (map.containsKey("orderstateid")) {
                    sbf.append(" and o.ORDERSTATEID = :orderstateid");
                }
                Query query = session.createSQLQuery(sbf.toString());
                query.setProperties(map);
                return query.uniqueResult();
            }
        }).toString());
        return count;
    }

    @Override
    public List findState() {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("SELECT * FROM orderstate ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public int findStateId(final String oname) {
        int orderstateid = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT os.ORDERSTATEID FROM orderstate os where os.ONAME = :oname ";
                Query query = session.createSQLQuery(sql);
                query.setString("oname", oname);
                return (int) query.uniqueResult();
            }
        });
        return orderstateid;
    }

    @Override
    public int addOrd(Orders orders) {
        return (int) this.hibernateTemplate.save(orders);
    }

    @Override
    public int addWay(Waybill waybill) {
        return (int) this.hibernateTemplate.save(waybill);
    }

    @Override
    public int findOrdId(final String orderno) {
        int orderid = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT o.ORDERID FROM orders o where o.ORDERNO = :orderno ";
                Query query = session.createSQLQuery(sql);
                query.setString("orderno", orderno);
                return (int) query.uniqueResult();
            }
        });
        return orderid;
    }

    @Override
    public List findOrdOne(final int orderid) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select o.ORDERID,o.ORDERNO,o.SENDNAME,o.SENDADDRESS,o.SENDTEL,o.SENDMOBTLE,o.SENDPOSTCODE,\n" +
                        "o.RECEIVENAME,o.RECEIVEADDRESS,o.RECEIVETEL,o.RECEIVEMODILE,o.RECEIVEPOSTCODE,o.ORDERSTATEID,\n" +
                        "(select os.ONAME from orderstate os where os.ORDERSTATEID = o.ORDERSTATEID) oname,\n" +
                        "w.TOTALPRICE,w.INSUREPRICE,w.GOODSPRICE,w.VOLUME,w.WEIGHT,w.REMARK,w.CREATETIME,w.DELIVERYSPOTID\n" +
                        "from orders o,waybill w\n" +
                        "where o.ORDERID = w.ORDERID \n" +
                        "and o.ORDERID = :orderid ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                query.setInteger("orderid", orderid);
                return query.list();
            }
        });
        return list;
    }
}
