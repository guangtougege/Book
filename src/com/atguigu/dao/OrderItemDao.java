package com.atguigu.dao;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);
}
