package com.atguigu.service;

import com.atguigu.bean.Cart;

public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart,Integer userId);
}
