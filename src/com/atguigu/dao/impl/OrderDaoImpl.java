package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
