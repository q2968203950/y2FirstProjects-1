package com.accp.dao;

import com.accp.pojo.Deliveryspot;

import java.util.List;
import java.util.Map;

public interface DeliveryspotDao {
    /**
     * 配送点分页查询
     *
     * @param map
     * @return
     */
    public List findDel(final Map<String, Object> map);

    /**
     * 总记录数
     *
     * @param map
     * @return
     */
    public long count(final Map<String, Object> map);

    /**
     * 添加配送点信息
     *
     * @param deliveryspot
     * @return
     */
    public int addDel(Deliveryspot deliveryspot);

    /**
     * 修改配送信息
     *
     * @param deliveryspot
     * @return
     */
    public int updateDel(Deliveryspot deliveryspot);

    /**
     * 逻辑删除配送信息
     *
     * @param deliveryspotid
     * @return
     */
    public int deleteDel(int deliveryspotid);

    /**
     * 根据配送点表ID添加管理员ID
     *
     * @param deliveryspotid
     * @return
     */
    public int updateDelEmpId(int deliveryspotid, int empid);

    /**
     * 查询配送点的所属城市
     *
     * @return
     */
    public List findDelPName();

    /**
     * 根据配送点ID获取一条数据
     *
     * @param deliveryspotid
     * @return
     */
    public Deliveryspot findDelC(int deliveryspotid);
}
