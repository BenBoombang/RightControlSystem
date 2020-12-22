package com.ben.rightMana.service;

import com.ben.rightMana.domain.Orders;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:03
 */
public interface OrdersService {

    // 查询所有订单
    List<Orders> findAll(int page,int size);
}
