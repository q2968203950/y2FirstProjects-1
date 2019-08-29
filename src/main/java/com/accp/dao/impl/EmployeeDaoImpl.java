package com.accp.dao.impl;

import com.accp.dao.EmployeeDao;
import com.accp.pojo.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List findEmp(final Map<String, Object> map) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select * from(\n" +
                        "SELECT e.*,\n" +
                        "(select p.PNAME from positions p where p.POSITIDNID = e.PSOITIONID) pname,\n" +
                        "(select \n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname\n" +
                        "from deliveryspot d where d.DELIVERYSPOTID = e.DELIVERYSPOTID) cname\n" +
                        "FROM employee e ) ee\n" +
                        "where 1 = 1 and ee.FLAG = 0 ");
                if (map.containsKey("deliveryspotid")) {
                    sbf.append(" and ee.DELIVERYSPOTID = :deliveryspotid");
                }
                if (map.containsKey("ename")) {
                    sbf.append(" and ee.ENAME like :ename");
                }
                if (map.containsKey("pname")) {
                    sbf.append(" and ee.pname = :pname");
                }
                if (map.containsKey("cname")) {
                    sbf.append(" and ee.cname like :cname");
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
                StringBuffer sbf = new StringBuffer("select count(ee.EMPID) from (SELECT e.*,\n" +
                        "(select p.PNAME from positions p where p.POSITIDNID = e.PSOITIONID) pname ,\n" +
                        "(select \n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname\n" +
                        "from deliveryspot d where d.DELIVERYSPOTID = e.DELIVERYSPOTID) cname\n" +
                        "FROM employee e ) ee\n" +
                        "where 1 = 1 and ee.FLAG = 0 ");
                if (map.containsKey("deliveryspotid")) {
                    sbf.append(" and ee.DELIVERYSPOTID = :deliveryspotid");
                }
                if (map.containsKey("ename")) {
                    sbf.append(" and ee.ENAME like :ename");
                }
                if (map.containsKey("pname")) {
                    sbf.append(" and ee.pname = :pname");
                }
                if (map.containsKey("cname")) {
                    sbf.append(" and ee.cname like :cname");
                }
                Query query = session.createSQLQuery(sbf.toString());
                query.setProperties(map);
                return query.uniqueResult();
            }
        }).toString());
        return count;
    }

    @Override
    public int addPos(Employee employee) {
        return (int) this.hibernateTemplate.save(employee);
    }

    @Override
    public int updatePos(Employee employee) {
        this.hibernateTemplate.update(employee);
        return 1;
    }

    @Override
    public int deletePos(int empid) {
        Employee employee = this.hibernateTemplate.get(Employee.class, empid);
        employee.setFlag(1);
        return 1;
    }

    @Override
    public List findEmpHis(final Map<String, Object> map) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select * from(\n" +
                        "SELECT e.*,\n" +
                        "(select p.PNAME from positions p where p.POSITIDNID = e.PSOITIONID) pname,\n" +
                        "(select \n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname\n" +
                        "from deliveryspot d where d.DELIVERYSPOTID = e.DELIVERYSPOTID) cname\n" +
                        "FROM employee e ) ee\n" +
                        "where 1 = 1 and ee.FLAG = 1 ");
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
    public long countHis(Map<String, Object> map) {
        Long count = Long.parseLong(this.hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                StringBuffer sbf = new StringBuffer("select count(ee.EMPID) from (SELECT e.*,\n" +
                        "(select p.PNAME from positions p where p.POSITIDNID = e.PSOITIONID) pname ,\n" +
                        "(select \n" +
                        "(select c.CNAME from city c where c.CITYID = d.CITYID) cname\n" +
                        "from deliveryspot d where d.DELIVERYSPOTID = e.DELIVERYSPOTID) cname\n" +
                        "FROM employee e ) ee\n" +
                        "where 1 = 1 and ee.FLAG = 1 ");
                Query query = session.createSQLQuery(sbf.toString());
                return query.uniqueResult();
            }
        }).toString());
        return count;
    }

    @Override
    public List findAll(final int deliveryspotid) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("SELECT * FROM employee e\n" +
                        "where e.DELIVERYSPOTID =:deliveryspotid ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                query.setInteger("deliveryspotid", deliveryspotid);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public List findPname(final int deliveryspotid) {
        List list = this.hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer sbf = new StringBuffer("select * from(SELECT e.*,\n" +
                        "(select p.PNAME from positions p where p.POSITIDNID = e.PSOITIONID) pname\n" +
                        " FROM employee e\n" +
                        " where e.DELIVERYSPOTID = :deliveryspotid) ee\n" +
                        " where ee.pname = '司机' ");
                Query query = session.createSQLQuery(sbf.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                query.setInteger("deliveryspotid", deliveryspotid);
                List list = query.list();
                return list;
            }
        });
        return list;
    }
}
