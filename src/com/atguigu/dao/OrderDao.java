package com.atguigu.dao;

import com.atguigu.bean.Order;

public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);
}
