package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.OrdersDao;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    public List<Orders> findAll(Map<String,Object> map) {
        Integer page =(Integer) map.get("page");
        Integer size =(Integer) map.get("size");
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public int queryCount() {
        return ordersDao.queryCount();
    }

    @Override
    public Orders queryById(String id) {
        return ordersDao.queryById(id);
    }


}
