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
    public List<Orders> pageQuery(Map<String,Object> map) {
        Integer page =Integer.valueOf(map.get("page").toString());
        Integer size =Integer.valueOf(map.get("size").toString());

        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }

        PageHelper.startPage(page,size);
        return ordersDao.pageQuery(queryText);
    }

    @Override
    public int queryCount() {
        return ordersDao.queryCount();
    }

    @Override
    public Orders queryById(String id) {
        return ordersDao.queryById(id);
    }

    @Override
    public void delete(Integer orderId) {
        ordersDao.delete(orderId);
    }

    @Override
    public List<Orders> exportQuery(Map<String, Object> map) {
        return ordersDao.exportQuery(map);
    }


}
