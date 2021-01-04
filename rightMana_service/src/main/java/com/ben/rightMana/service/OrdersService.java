package com.ben.rightMana.service;

import com.ben.rightMana.domain.Orders;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 20:03
 */
public interface OrdersService {

    // 查询所有订单
    List<Orders> pageQuery(Map<String,Object> map);

    int queryCount();

    Orders queryById(String id);

    void delete(Integer orderId);

    List<Orders> exportQuery(Map<String, Object> map);
}
