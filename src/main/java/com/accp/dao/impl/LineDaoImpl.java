package com.accp.dao.impl;

import com.accp.dao.LineDao;
import com.accp.pojo.Line;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;
@SuppressWarnings("all")
public class LineDaoImpl extends HibernateDaoSupport implements LineDao {
    /**
     * 查询所有的线路信息
     * @return
     */
    @Override
    public List<Line> getLineAll() {
        String hql = "from Line";
        List<Line> list = (List<Line>)this.getHibernateTemplate().find(hql);
        return list;
    }
}
