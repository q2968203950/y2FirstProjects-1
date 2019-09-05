package com.accp.dao.impl;

import com.accp.dao.ReceiptDao;
import com.accp.pojo.Orders;
import com.accp.pojo.Receipt;
import com.accp.pojo.Receiptdetaile;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;

public class ReceiptDaoImpl implements ReceiptDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findCarno(final int empid) {
        List carno = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("SELECT * FROM car c\n" +
                        "where c.EMPID = :empid ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                query.setInteger("empid", empid);
                return query.list();
            }
        });
        return carno;
    }

    @Override
    public int addRec(Receipt receipt) {
        return (int) this.hibernateTemplate.save(receipt);
    }

    @Override
    public int findRecId() {
        int receiptid = this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException, SQLException {
                String sql = "SELECT r.RECEIPTID FROM receipt r order by r.RECEIPTID desc limit 0,1 ";
                Query query = session.createSQLQuery(sql);
                return (int) query.uniqueResult();
            }
        });
        return receiptid;
    }

    @Override
    public int addRecDet(Receiptdetaile receiptdetaile) {
        return (int) this.hibernateTemplate.save(receiptdetaile);
    }

    @Override
    public int updateOrdState(int orderid) {
        Orders orders = this.hibernateTemplate.get(Orders.class, orderid);
        orders.setOrderstateid(3);
        return 1;
    }
}
