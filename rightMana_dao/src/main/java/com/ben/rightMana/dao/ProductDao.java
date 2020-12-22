package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 16:23
 */
public interface ProductDao {

    // 查询所有商品信息
    @Select("select * from product")
    List<Product> findAll();

    void save(Product product);

    // 根据id查对应的产品
    Product findById(String id);
}
