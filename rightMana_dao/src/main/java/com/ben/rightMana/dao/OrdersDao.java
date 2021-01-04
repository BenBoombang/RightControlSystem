package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Member;
import com.ben.rightMana.domain.Orders;
import com.ben.rightMana.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 20:05
 */
public interface OrdersDao {
    @Select({"<script>" +
            "select * from orders " +
            "where 1=1 " +
            "<if test='queryText != null'>" +
            "and orderNum like concat('%',#{queryText},'%')" +
            "</if>" +
            "</script>"})
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
    List<Orders> pageQuery(@Param("queryText") String queryText);


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

    @Delete("delete from orders where id = #{orderId}")
    void delete(@Param("orderId") Integer orderId);

    List<Orders> exportQuery(Map<String, Object> map);
}
