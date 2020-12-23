package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:53
 */
public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> queryByOrderId(String orderId);
}
