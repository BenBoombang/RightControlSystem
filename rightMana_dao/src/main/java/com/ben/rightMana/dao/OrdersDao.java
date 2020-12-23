package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Member;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.domain.Product;
import org.apache.ibatis.annotations.*;

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


    @Select("select count(*) as countNum from orders")
    int queryCount();


    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.ben.rightMana.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.ben.rightMana.dao.MemberDao.queryById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ben.rightMana.dao.TravellerDao.queryByOrderId"))
    })
    Orders queryById(String id);
}
