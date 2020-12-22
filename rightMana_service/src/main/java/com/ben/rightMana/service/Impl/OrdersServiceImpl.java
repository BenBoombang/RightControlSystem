package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.OrdersDao;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:04
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
}
