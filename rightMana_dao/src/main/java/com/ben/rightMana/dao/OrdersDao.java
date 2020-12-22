package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:05
 */
public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.ben.rightMana.dao.ProductDao.findById")),
    })
    List<Orders> findAll();
}
